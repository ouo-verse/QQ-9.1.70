package com.epicgames.ue4;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.text.DecimalFormat;
import java.util.Stack;

/* loaded from: classes2.dex */
public class GameProfiler {
    private DecimalFormat _fmt;
    private Stack<Interval> _intervals;
    private long _startTime;
    private StringBuilder _stringBuilder;
    private StringBuilder _stringCollector;
    private boolean _enabled = false;
    private final int STACK_INDEX = 5;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Interval {
        private long beginTime = System.currentTimeMillis();
        public String message;

        public Interval(String str) {
            this.message = str;
        }
    }

    public GameProfiler(boolean z16) {
        setEnabled(z16);
        this._startTime = currentMilliseconds();
    }

    private void begin(String str, int i3) {
        this._stringBuilder.setLength(0);
        StringBuilder sb5 = new StringBuilder(50);
        timepoint_string(this._stringBuilder);
        ident_string(this._stringBuilder);
        this._stringBuilder.append(" { ");
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i3];
        sb5.append(stackTraceElement.getClassName());
        sb5.append(".");
        sb5.append(stackTraceElement.getMethodName());
        sb5.append(str);
        this._stringBuilder.append((CharSequence) sb5);
        this._stringBuilder.append(" Begin ");
        this._intervals.push(new Interval(sb5.toString()));
        println(this._stringBuilder);
    }

    public static long currentMilliseconds() {
        return System.currentTimeMillis();
    }

    public static long elapsedMilliseconds(long j3) {
        return currentMilliseconds() - j3;
    }

    public static double elapsedSeconds(long j3) {
        return elapsedMilliseconds(j3) / 1000.0d;
    }

    private void elapsedtime_string(long j3, StringBuilder sb5) {
        sb5.append(this._fmt.format(elapsedSeconds(j3)));
        sb5.append(ReportConstant.COSTREPORT_PREFIX);
    }

    private void ident_string(StringBuilder sb5) {
        for (int i3 = 0; i3 < this._intervals.size(); i3++) {
            this._stringBuilder.append("  ");
        }
    }

    private void println(StringBuilder sb5) {
        if (this._stringCollector == null) {
            this._stringCollector = new StringBuilder(2000);
        }
        this._stringCollector.append("[BT] " + sb5.toString() + "\n");
    }

    private void timepoint(String str, int i3) {
        this._stringBuilder.setLength(0);
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i3];
        timepoint_string(this._stringBuilder);
        this._stringBuilder.append(" ");
        this._stringBuilder.append(stackTraceElement.getClassName());
        this._stringBuilder.append(".");
        this._stringBuilder.append(stackTraceElement.getMethodName());
        this._stringBuilder.append(" ");
        this._stringBuilder.append(str);
        println(this._stringBuilder);
    }

    private void timepoint_string(StringBuilder sb5) {
        sb5.append("TIMEPOINT: ");
        elapsedtime_string(this._startTime, sb5);
    }

    public void disable() {
        setEnabled(false);
    }

    public void dump() {
        if (this._stringCollector != null) {
            UE4.log("[BT]**************GameProfiler Dump Begin**************");
            UE4.log(this._stringCollector.toString());
            UE4.log("[BT]**************GameProfiler Dump End**************");
            this._stringCollector = null;
        }
    }

    public void enable() {
        setEnabled(true);
    }

    public void end() {
        if (!this._enabled) {
            return;
        }
        Interval pop = this._intervals.pop();
        this._stringBuilder.setLength(0);
        timepoint_string(this._stringBuilder);
        ident_string(this._stringBuilder);
        this._stringBuilder.append(" } ");
        this._stringBuilder.append(pop.message);
        this._stringBuilder.append(" End, TOOK: ");
        elapsedtime_string(pop.beginTime, this._stringBuilder);
        println(this._stringBuilder);
    }

    public boolean isEnabled() {
        return this._enabled;
    }

    public void setEnabled(boolean z16) {
        if (this._enabled == z16) {
            return;
        }
        this._enabled = z16;
        if (z16) {
            this._intervals = new Stack<>();
            this._fmt = new DecimalFormat("#.0000");
            this._stringBuilder = new StringBuilder(100);
        } else {
            this._intervals = null;
            this._fmt = null;
            this._stringBuilder = null;
            this._stringCollector = null;
        }
    }

    private void timepoint_string(String str, StringBuilder sb5) {
        timepoint_string(sb5);
        sb5.append(" ");
        sb5.append(str);
    }

    public void timepoint(String str) {
        if (this._enabled) {
            timepoint(str, 5);
        }
    }

    public void timepoint() {
        if (this._enabled) {
            timepoint("", 5);
        }
    }

    public void begin(String str) {
        if (this._enabled) {
            begin("-" + str, 5);
        }
    }

    public void begin() {
        if (this._enabled) {
            begin("", 5);
        }
    }
}
