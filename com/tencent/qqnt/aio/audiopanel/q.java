package com.tencent.qqnt.aio.audiopanel;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.RecordParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\r\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\r\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q;", "Lat/c;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/audiopanel/q$a;", "Lcom/tencent/qqnt/aio/audiopanel/q$b;", "Lcom/tencent/qqnt/aio/audiopanel/q$c;", "Lcom/tencent/qqnt/aio/audiopanel/q$d;", "Lcom/tencent/qqnt/aio/audiopanel/q$e;", "Lcom/tencent/qqnt/aio/audiopanel/q$f;", "Lcom/tencent/qqnt/aio/audiopanel/q$g;", "Lcom/tencent/qqnt/aio/audiopanel/q$h;", "Lcom/tencent/qqnt/aio/audiopanel/q$i;", "Lcom/tencent/qqnt/aio/audiopanel/q$j;", "Lcom/tencent/qqnt/aio/audiopanel/q$k;", "Lcom/tencent/qqnt/aio/audiopanel/q$l;", "Lcom/tencent/qqnt/aio/audiopanel/q$m;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class q implements at.c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$b;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends q {

        /* renamed from: d, reason: collision with root package name */
        public static final b f349711d = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$c;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "b", "(Z)V", "isRobotAIO", "<init>", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class GetAIOTypeIntent extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isRobotAIO;

        /* renamed from: a, reason: from getter */
        public final boolean getIsRobotAIO() {
            return this.isRobotAIO;
        }

        public final void b(boolean z16) {
            this.isRobotAIO = z16;
        }

        public int hashCode() {
            boolean z16 = this.isRobotAIO;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "GetAIOTypeIntent(isRobotAIO=" + this.isRobotAIO + ")";
        }

        public GetAIOTypeIntent(boolean z16) {
            super(null);
            this.isRobotAIO = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetAIOTypeIntent) && this.isRobotAIO == ((GetAIOTypeIntent) other).isRobotAIO;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$d;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "getChatType", "()I", "a", "(I)V", "chatType", "<init>", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$d, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class GetChatType extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int chatType;

        public GetChatType() {
            this(0, 1, null);
        }

        public final void a(int i3) {
            this.chatType = i3;
        }

        /* renamed from: hashCode, reason: from getter */
        public int getChatType() {
            return this.chatType;
        }

        public String toString() {
            return "GetChatType(chatType=" + this.chatType + ")";
        }

        public GetChatType(int i3) {
            super(null);
            this.chatType = i3;
        }

        public /* synthetic */ GetChatType(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetChatType) && this.chatType == ((GetChatType) other).chatType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$e;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "state", "<init>", "(Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$e, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class PanelBlurViewChange extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean state;

        /* renamed from: a, reason: from getter */
        public final boolean getState() {
            return this.state;
        }

        public int hashCode() {
            boolean z16 = this.state;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "PanelBlurViewChange(state=" + this.state + ")";
        }

        public PanelBlurViewChange(boolean z16) {
            super(null);
            this.state = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PanelBlurViewChange) && this.state == ((PanelBlurViewChange) other).state;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$f;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "bEditState", "<init>", "(Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$f, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class PanelUIStateChange extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean bEditState;

        /* renamed from: a, reason: from getter */
        public final boolean getBEditState() {
            return this.bEditState;
        }

        public int hashCode() {
            boolean z16 = this.bEditState;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "PanelUIStateChange(bEditState=" + this.bEditState + ")";
        }

        public PanelUIStateChange(boolean z16) {
            super(null);
            this.bEditState = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PanelUIStateChange) && this.bEditState == ((PanelUIStateChange) other).bEditState;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$g;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "e", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "b", "()Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "recordParams", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$g, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class RecordEndEvent extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final RecordParams.RecorderParam recordParams;

        /* renamed from: a, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: b, reason: from getter */
        public final RecordParams.RecorderParam getRecordParams() {
            return this.recordParams;
        }

        public int hashCode() {
            String str = this.path;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            RecordParams.RecorderParam recorderParam = this.recordParams;
            return hashCode + (recorderParam != null ? recorderParam.hashCode() : 0);
        }

        public String toString() {
            return "RecordEndEvent(path=" + this.path + ", recordParams=" + this.recordParams + ")";
        }

        public RecordEndEvent(String str, RecordParams.RecorderParam recorderParam) {
            super(null);
            this.path = str;
            this.recordParams = recorderParam;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecordEndEvent)) {
                return false;
            }
            RecordEndEvent recordEndEvent = (RecordEndEvent) other;
            return Intrinsics.areEqual(this.path, recordEndEvent.path) && Intrinsics.areEqual(this.recordParams, recordEndEvent.recordParams);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$h;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h extends q {

        /* renamed from: d, reason: collision with root package name */
        public static final h f349718d = new h();

        h() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$m;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "sync", "<init>", "(Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$m, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class StopRecordEvent extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean sync;

        /* renamed from: a, reason: from getter */
        public final boolean getSync() {
            return this.sync;
        }

        public int hashCode() {
            boolean z16 = this.sync;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "StopRecordEvent(sync=" + this.sync + ")";
        }

        public StopRecordEvent(boolean z16) {
            super(null);
            this.sync = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StopRecordEvent) && this.sync == ((StopRecordEvent) other).sync;
        }
    }

    public /* synthetic */ q(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    q() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$a;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "msgId", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class CancelFakeIntent extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgId;

        /* renamed from: a, reason: from getter */
        public final long getMsgId() {
            return this.msgId;
        }

        public int hashCode() {
            return com.tencent.mobileqq.perf.api.impl.b.a(this.msgId);
        }

        public String toString() {
            return "CancelFakeIntent(msgId=" + this.msgId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CancelFakeIntent) && this.msgId == ((CancelFakeIntent) other).msgId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R'\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#R\u0017\u0010'\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010#R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b\n\u0010-\"\u0004\b.\u0010/\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$i;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "path", "", UserInfo.SEX_FEMALE, "c", "()F", "duration", "f", "I", "b", "()I", "audioType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "audioData", "i", "Z", "()Z", "isVoiceChange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "isAutoConvertText", BdhLogUtil.LogTag.Tag_Conn, "voiceChangeType", "", "D", "J", "()J", "setMsgId", "(J)V", "msgId", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$i, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class SendFakeIntent extends q {

        /* renamed from: C, reason: from kotlin metadata and from toString */
        private final int voiceChangeType;

        /* renamed from: D, reason: from kotlin metadata and from toString */
        private long msgId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final float duration;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int audioType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final ArrayList<Byte> audioData;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isVoiceChange;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isAutoConvertText;

        public final ArrayList<Byte> a() {
            return this.audioData;
        }

        /* renamed from: b, reason: from getter */
        public final int getAudioType() {
            return this.audioType;
        }

        /* renamed from: c, reason: from getter */
        public final float getDuration() {
            return this.duration;
        }

        /* renamed from: d, reason: from getter */
        public final long getMsgId() {
            return this.msgId;
        }

        /* renamed from: e, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: f, reason: from getter */
        public final int getVoiceChangeType() {
            return this.voiceChangeType;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsAutoConvertText() {
            return this.isAutoConvertText;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getIsVoiceChange() {
            return this.isVoiceChange;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.path.hashCode() * 31) + Float.floatToIntBits(this.duration)) * 31) + this.audioType) * 31) + this.audioData.hashCode()) * 31;
            boolean z16 = this.isVoiceChange;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            boolean z17 = this.isAutoConvertText;
            return ((((i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.voiceChangeType) * 31) + com.tencent.mobileqq.perf.api.impl.b.a(this.msgId);
        }

        public String toString() {
            return "SendFakeIntent(path=" + this.path + ", duration=" + this.duration + ", audioType=" + this.audioType + ", audioData=" + this.audioData + ", isVoiceChange=" + this.isVoiceChange + ", isAutoConvertText=" + this.isAutoConvertText + ", voiceChangeType=" + this.voiceChangeType + ", msgId=" + this.msgId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendFakeIntent)) {
                return false;
            }
            SendFakeIntent sendFakeIntent = (SendFakeIntent) other;
            return Intrinsics.areEqual(this.path, sendFakeIntent.path) && Float.compare(this.duration, sendFakeIntent.duration) == 0 && this.audioType == sendFakeIntent.audioType && Intrinsics.areEqual(this.audioData, sendFakeIntent.audioData) && this.isVoiceChange == sendFakeIntent.isVoiceChange && this.isAutoConvertText == sendFakeIntent.isAutoConvertText && this.voiceChangeType == sendFakeIntent.voiceChangeType && this.msgId == sendFakeIntent.msgId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b\u0012\u0006\u0010$\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R'\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#R\u0017\u0010'\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010#R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R$\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b\n\u0010-\"\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$j;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "path", "", UserInfo.SEX_FEMALE, "c", "()F", "duration", "f", "I", "b", "()I", "audioType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "audioData", "i", "Z", "()Z", "isVoiceChange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "isAutoConvertText", BdhLogUtil.LogTag.Tag_Conn, "voiceChangeType", "", "D", "Ljava/lang/Long;", "()Ljava/lang/Long;", "setMsgId", "(Ljava/lang/Long;)V", "msgId", "<init>", "(Ljava/lang/String;FILjava/util/ArrayList;ZZILjava/lang/Long;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$j, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class SendIntent extends q {

        /* renamed from: C, reason: from kotlin metadata and from toString */
        private final int voiceChangeType;

        /* renamed from: D, reason: from kotlin metadata and from toString */
        private Long msgId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final float duration;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int audioType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final ArrayList<Byte> audioData;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isVoiceChange;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isAutoConvertText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendIntent(String path, float f16, int i3, ArrayList<Byte> audioData, boolean z16, boolean z17, int i16, Long l3) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(audioData, "audioData");
            this.path = path;
            this.duration = f16;
            this.audioType = i3;
            this.audioData = audioData;
            this.isVoiceChange = z16;
            this.isAutoConvertText = z17;
            this.voiceChangeType = i16;
            this.msgId = l3;
        }

        public final ArrayList<Byte> a() {
            return this.audioData;
        }

        /* renamed from: b, reason: from getter */
        public final int getAudioType() {
            return this.audioType;
        }

        /* renamed from: c, reason: from getter */
        public final float getDuration() {
            return this.duration;
        }

        /* renamed from: d, reason: from getter */
        public final Long getMsgId() {
            return this.msgId;
        }

        /* renamed from: e, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: f, reason: from getter */
        public final int getVoiceChangeType() {
            return this.voiceChangeType;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsAutoConvertText() {
            return this.isAutoConvertText;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getIsVoiceChange() {
            return this.isVoiceChange;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.path.hashCode() * 31) + Float.floatToIntBits(this.duration)) * 31) + this.audioType) * 31) + this.audioData.hashCode()) * 31;
            boolean z16 = this.isVoiceChange;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            boolean z17 = this.isAutoConvertText;
            int i17 = (((i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31) + this.voiceChangeType) * 31;
            Long l3 = this.msgId;
            return i17 + (l3 == null ? 0 : l3.hashCode());
        }

        public String toString() {
            return "SendIntent(path=" + this.path + ", duration=" + this.duration + ", audioType=" + this.audioType + ", audioData=" + this.audioData + ", isVoiceChange=" + this.isVoiceChange + ", isAutoConvertText=" + this.isAutoConvertText + ", voiceChangeType=" + this.voiceChangeType + ", msgId=" + this.msgId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendIntent)) {
                return false;
            }
            SendIntent sendIntent = (SendIntent) other;
            return Intrinsics.areEqual(this.path, sendIntent.path) && Float.compare(this.duration, sendIntent.duration) == 0 && this.audioType == sendIntent.audioType && Intrinsics.areEqual(this.audioData, sendIntent.audioData) && this.isVoiceChange == sendIntent.isVoiceChange && this.isAutoConvertText == sendIntent.isAutoConvertText && this.voiceChangeType == sendIntent.voiceChangeType && Intrinsics.areEqual(this.msgId, sendIntent.msgId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$k;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$k, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class SendTextIntent extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendTextIntent(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "SendTextIntent(text=" + this.text + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SendTextIntent) && Intrinsics.areEqual(this.text, ((SendTextIntent) other).text);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/q$l;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "path", "Lcom/tencent/mobileqq/ptt/d$a;", "e", "Lcom/tencent/mobileqq/ptt/d$a;", "a", "()Lcom/tencent/mobileqq/ptt/d$a;", "listener", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "f", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "c", "()Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "recordParams", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/ptt/d$a;Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.audiopanel.q$l, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class StartRecordEvent extends q {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final d.a listener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final RecordParams.RecorderParam recordParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartRecordEvent(String path, d.a listener, RecordParams.RecorderParam recordParams) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(recordParams, "recordParams");
            this.path = path;
            this.listener = listener;
            this.recordParams = recordParams;
        }

        /* renamed from: a, reason: from getter */
        public final d.a getListener() {
            return this.listener;
        }

        /* renamed from: b, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: c, reason: from getter */
        public final RecordParams.RecorderParam getRecordParams() {
            return this.recordParams;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + this.listener.hashCode()) * 31) + this.recordParams.hashCode();
        }

        public String toString() {
            return "StartRecordEvent(path=" + this.path + ", listener=" + this.listener + ", recordParams=" + this.recordParams + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartRecordEvent)) {
                return false;
            }
            StartRecordEvent startRecordEvent = (StartRecordEvent) other;
            return Intrinsics.areEqual(this.path, startRecordEvent.path) && Intrinsics.areEqual(this.listener, startRecordEvent.listener) && Intrinsics.areEqual(this.recordParams, startRecordEvent.recordParams);
        }
    }
}
