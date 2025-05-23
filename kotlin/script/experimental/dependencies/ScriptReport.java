package kotlin.script.experimental.dependencies;

import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lkotlin/script/experimental/dependencies/ScriptReport;", "", "message", "", "severity", "Lkotlin/script/experimental/dependencies/ScriptReport$Severity;", "position", "Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "(Ljava/lang/String;Lkotlin/script/experimental/dependencies/ScriptReport$Severity;Lkotlin/script/experimental/dependencies/ScriptReport$Position;)V", "getMessage", "()Ljava/lang/String;", "getPosition", "()Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "getSeverity", "()Lkotlin/script/experimental/dependencies/ScriptReport$Severity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Position", "Severity", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes38.dex */
public final /* data */ class ScriptReport {
    private final String message;
    private final Position position;
    private final Severity severity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\tJ:\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "", "startLine", "", "startColumn", "endLine", "endColumn", "(IILjava/lang/Integer;Ljava/lang/Integer;)V", "getEndColumn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndLine", "getStartColumn", "()I", "getStartLine", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Integer;Ljava/lang/Integer;)Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "equals", "", "other", "hashCode", "toString", "", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final /* data */ class Position {
        private final Integer endColumn;
        private final Integer endLine;
        private final int startColumn;
        private final int startLine;

        public Position(int i3, int i16, Integer num, Integer num2) {
            this.startLine = i3;
            this.startColumn = i16;
            this.endLine = num;
            this.endColumn = num2;
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartLine() {
            return this.startLine;
        }

        /* renamed from: component2, reason: from getter */
        public final int getStartColumn() {
            return this.startColumn;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getEndLine() {
            return this.endLine;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getEndColumn() {
            return this.endColumn;
        }

        public final Position copy(int startLine, int startColumn, Integer endLine, Integer endColumn) {
            return new Position(startLine, startColumn, endLine, endColumn);
        }

        public final Integer getEndColumn() {
            return this.endColumn;
        }

        public final Integer getEndLine() {
            return this.endLine;
        }

        public final int getStartColumn() {
            return this.startColumn;
        }

        public final int getStartLine() {
            return this.startLine;
        }

        public int hashCode() {
            int i3 = ((this.startLine * 31) + this.startColumn) * 31;
            Integer num = this.endLine;
            int hashCode = (i3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.endColumn;
            return hashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "Position(startLine=" + this.startLine + ", startColumn=" + this.startColumn + ", endLine=" + this.endLine + ", endColumn=" + this.endColumn + ')';
        }

        public /* synthetic */ Position(int i3, int i16, Integer num, Integer num2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i16, (i17 & 4) != 0 ? null : num, (i17 & 8) != 0 ? null : num2);
        }

        public static /* synthetic */ Position copy$default(Position position, int i3, int i16, Integer num, Integer num2, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = position.startLine;
            }
            if ((i17 & 2) != 0) {
                i16 = position.startColumn;
            }
            if ((i17 & 4) != 0) {
                num = position.endLine;
            }
            if ((i17 & 8) != 0) {
                num2 = position.endColumn;
            }
            return position.copy(i3, i16, num, num2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Position)) {
                return false;
            }
            Position position = (Position) other;
            return this.startLine == position.startLine && this.startColumn == position.startColumn && Intrinsics.areEqual(this.endLine, position.endLine) && Intrinsics.areEqual(this.endColumn, position.endColumn);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lkotlin/script/experimental/dependencies/ScriptReport$Severity;", "", "(Ljava/lang/String;I)V", "FATAL", RLog.ERROR, "WARNING", "INFO", "DEBUG", "kotlin-script-runtime"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public enum Severity {
        FATAL,
        ERROR,
        WARNING,
        INFO,
        DEBUG
    }

    public ScriptReport(String message, Severity severity, Position position) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(severity, "severity");
        this.message = message;
        this.severity = severity;
        this.position = position;
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final Severity getSeverity() {
        return this.severity;
    }

    /* renamed from: component3, reason: from getter */
    public final Position getPosition() {
        return this.position;
    }

    public final ScriptReport copy(String message, Severity severity, Position position) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(severity, "severity");
        return new ScriptReport(message, severity, position);
    }

    public final String getMessage() {
        return this.message;
    }

    public final Position getPosition() {
        return this.position;
    }

    public final Severity getSeverity() {
        return this.severity;
    }

    public int hashCode() {
        int hashCode = ((this.message.hashCode() * 31) + this.severity.hashCode()) * 31;
        Position position = this.position;
        return hashCode + (position == null ? 0 : position.hashCode());
    }

    public String toString() {
        return "ScriptReport(message=" + this.message + ", severity=" + this.severity + ", position=" + this.position + ')';
    }

    public /* synthetic */ ScriptReport(String str, Severity severity, Position position, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? Severity.ERROR : severity, (i3 & 4) != 0 ? null : position);
    }

    public static /* synthetic */ ScriptReport copy$default(ScriptReport scriptReport, String str, Severity severity, Position position, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = scriptReport.message;
        }
        if ((i3 & 2) != 0) {
            severity = scriptReport.severity;
        }
        if ((i3 & 4) != 0) {
            position = scriptReport.position;
        }
        return scriptReport.copy(str, severity, position);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScriptReport)) {
            return false;
        }
        ScriptReport scriptReport = (ScriptReport) other;
        return Intrinsics.areEqual(this.message, scriptReport.message) && this.severity == scriptReport.severity && Intrinsics.areEqual(this.position, scriptReport.position);
    }
}
