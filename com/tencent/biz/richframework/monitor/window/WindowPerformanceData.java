package com.tencent.biz.richframework.monitor.window;

import com.heytap.databaseengine.model.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010;\u001a\u00020\u0004\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRJ\u0010\u0014\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u00110\u0010j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR>\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010-j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u001f\u001a\u0004\b9\u0010!\"\u0004\b:\u0010#R\u0017\u0010;\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\u00a8\u0006A"}, d2 = {"Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "totalCount", "J", "getTotalCount", "()J", "setTotalCount", "(J)V", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "fps", "Ljava/util/ArrayList;", "getFps", "()Ljava/util/ArrayList;", "setFps", "(Ljava/util/ArrayList;)V", "maxFrameTime", "getMaxFrameTime", "setMaxFrameTime", "", "maxFrameCombination", "[J", "getMaxFrameCombination", "()[J", "setMaxFrameCombination", "([J)V", "fluency", UserInfo.SEX_FEMALE, "getFluency", "()F", "setFluency", "(F)V", "monitorDuration", "getMonitorDuration", "setMonitorDuration", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extMap", "Ljava/util/HashMap;", "getExtMap", "()Ljava/util/HashMap;", "setExtMap", "(Ljava/util/HashMap;)V", "firstDrawTime", "getFirstDrawTime", "setFirstDrawTime", "firstDrawTimeCombination", "getFirstDrawTimeCombination", "setFirstDrawTimeCombination", "refresh", "I", "getRefresh", "()I", "<init>", "(I)V", "monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class WindowPerformanceData {
    private long firstDrawTime;

    @Nullable
    private long[] firstDrawTimeCombination;
    private float fluency;

    @Nullable
    private long[] maxFrameCombination;
    private long maxFrameTime;
    private long monitorDuration;
    private final int refresh;
    private long totalCount;

    @NotNull
    private ArrayList<Pair<Integer, Float>> fps = new ArrayList<>();

    @NotNull
    private HashMap<String, Object> extMap = new HashMap<>();

    public WindowPerformanceData(int i3) {
        this.refresh = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof WindowPerformanceData) || this.refresh != ((WindowPerformanceData) other).refresh) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final HashMap<String, Object> getExtMap() {
        return this.extMap;
    }

    public final long getFirstDrawTime() {
        return this.firstDrawTime;
    }

    @Nullable
    public final long[] getFirstDrawTimeCombination() {
        return this.firstDrawTimeCombination;
    }

    public final float getFluency() {
        return this.fluency;
    }

    @NotNull
    public final ArrayList<Pair<Integer, Float>> getFps() {
        return this.fps;
    }

    @Nullable
    public final long[] getMaxFrameCombination() {
        return this.maxFrameCombination;
    }

    public final long getMaxFrameTime() {
        return this.maxFrameTime;
    }

    public final long getMonitorDuration() {
        return this.monitorDuration;
    }

    public final int getRefresh() {
        return this.refresh;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return this.refresh;
    }

    public final void setFirstDrawTime(long j3) {
        this.firstDrawTime = j3;
    }

    public final void setFirstDrawTimeCombination(@Nullable long[] jArr) {
        this.firstDrawTimeCombination = jArr;
    }

    public final void setFluency(float f16) {
        this.fluency = f16;
    }

    public final void setMaxFrameCombination(@Nullable long[] jArr) {
        this.maxFrameCombination = jArr;
    }

    public final void setMaxFrameTime(long j3) {
        this.maxFrameTime = j3;
    }

    public final void setMonitorDuration(long j3) {
        this.monitorDuration = j3;
    }

    public final void setTotalCount(long j3) {
        this.totalCount = j3;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("refresh:");
        sb5.append(this.refresh);
        sb5.append(',');
        sb5.append("fps:");
        sb5.append(this.fps);
        sb5.append(',');
        sb5.append("maxFrameTime:");
        sb5.append(this.maxFrameTime);
        sb5.append(',');
        sb5.append("maxFrameCombination:");
        long[] jArr = this.maxFrameCombination;
        String str2 = null;
        if (jArr != null) {
            str = ArraysKt___ArraysKt.joinToString$default(jArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Long, CharSequence>() { // from class: com.tencent.biz.richframework.monitor.window.WindowPerformanceData$toString$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Long l3) {
                    return invoke(l3.longValue());
                }

                @NotNull
                public final CharSequence invoke(long j3) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(j3);
                    sb6.append(TokenParser.SP);
                    return sb6.toString();
                }
            }, 31, (Object) null);
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(',');
        sb5.append("fluency:");
        sb5.append(this.fluency);
        sb5.append(',');
        sb5.append("monitorDuration");
        sb5.append(this.monitorDuration);
        sb5.append(',');
        sb5.append("firstDrawTime:");
        sb5.append(this.firstDrawTime);
        sb5.append(',');
        sb5.append("firstDrawTimeCombination");
        long[] jArr2 = this.firstDrawTimeCombination;
        if (jArr2 != null) {
            str2 = ArraysKt___ArraysKt.joinToString$default(jArr2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Long, CharSequence>() { // from class: com.tencent.biz.richframework.monitor.window.WindowPerformanceData$toString$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Long l3) {
                    return invoke(l3.longValue());
                }

                @NotNull
                public final CharSequence invoke(long j3) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(j3);
                    sb6.append(TokenParser.SP);
                    return sb6.toString();
                }
            }, 31, (Object) null);
        }
        sb5.append(str2);
        return sb5.toString();
    }
}
