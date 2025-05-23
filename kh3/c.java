package kh3;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory;
import com.tencent.mobileqq.zplan.meme.animation2D.Anim2DEncoderHelper;
import com.tencent.mobileqq.zplan.meme.animation2D.Anim2DFileCacheUtil;
import com.tencent.mobileqq.zplan.meme.animation2D.Anim2DRecordData;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.meme.action.MODE;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nh3.ZPlanEmoticonReportData;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003A48B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J0\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002JJ\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J*\u0010&\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JU\u0010.\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b.\u0010/J:\u00100\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020*J:\u00101\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020*J\u0006\u00102\u001a\u00020\u0004R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\b078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lkh3/c;", "", "Ljava/lang/Runnable;", "runable", "", "u", "Lcom/tencent/mobileqq/zplan/model/e;", "actionInfo", "", "selfUin", "avatarPath", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lkh3/c$b;", "listener", "p", "keyCover", "keyGif", "g", "key", "j", "", "ret", "retPath", "", "runnableStartTime", "downloadTimeCost", "encodeTimeCost", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zplan/meme/animation2D/c;", "data", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "", "success", "Lkh3/c$c;", "reportData", "w", "i", "startTime", "Ljh3/b;", "Lnh3/b;", "recordReportData", "recordAppearanceKey", "needRefreshView", "r", "(Ljava/lang/String;Lcom/tencent/mobileqq/zplan/model/e;Ljava/lang/String;JLjh3/b;Lnh3/b;Ljava/lang/String;Ljava/lang/Boolean;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "o", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "encodingKeyList", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "encodingKeyListenerMap", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a */
    public static final c f412361a = new c();

    /* renamed from: b, reason: from kotlin metadata */
    private static final ReentrantLock org.aspectj.lang.JoinPoint.SYNCHRONIZATION_LOCK java.lang.String = new ReentrantLock();

    /* renamed from: c, reason: from kotlin metadata */
    private static final CopyOnWriteArrayList<String> encodingKeyList = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: from kotlin metadata */
    private static final ConcurrentHashMap<String, b> encodingKeyListenerMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lkh3/c$b;", "", "", "success", "", "path", "Lkh3/c$c;", "data", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        void a(boolean success, String path, ZPlanEmo2DReportData data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0015\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lkh3/c$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "errCode", "", "b", "J", "e", "()J", "runnableStartTime", "downloadTimeCost", "d", "encodeTimeCost", "Z", "()Z", "f", "(Z)V", "realEncode", "<init>", "(IJJJZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kh3.c$c, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class ZPlanEmo2DReportData {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final int errCode;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final long runnableStartTime;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final long downloadTimeCost;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final long encodeTimeCost;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        private boolean realEncode;

        public ZPlanEmo2DReportData() {
            this(0, 0L, 0L, 0L, false, 31, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getDownloadTimeCost() {
            return this.downloadTimeCost;
        }

        /* renamed from: b, reason: from getter */
        public final long getEncodeTimeCost() {
            return this.encodeTimeCost;
        }

        /* renamed from: c, reason: from getter */
        public final int getErrCode() {
            return this.errCode;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getRealEncode() {
            return this.realEncode;
        }

        /* renamed from: e, reason: from getter */
        public final long getRunnableStartTime() {
            return this.runnableStartTime;
        }

        public final void f(boolean z16) {
            this.realEncode = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((((this.errCode * 31) + com.tencent.mobileqq.vas.banner.c.a(this.runnableStartTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.downloadTimeCost)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.encodeTimeCost)) * 31;
            boolean z16 = this.realEncode;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        public String toString() {
            return "ZPlanEmo2DReportData(errCode=" + this.errCode + ", runnableStartTime=" + this.runnableStartTime + ", downloadTimeCost=" + this.downloadTimeCost + ", encodeTimeCost=" + this.encodeTimeCost + ", realEncode=" + this.realEncode + ")";
        }

        public ZPlanEmo2DReportData(int i3, long j3, long j16, long j17, boolean z16) {
            this.errCode = i3;
            this.runnableStartTime = j3;
            this.downloadTimeCost = j16;
            this.encodeTimeCost = j17;
            this.realEncode = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZPlanEmo2DReportData)) {
                return false;
            }
            ZPlanEmo2DReportData zPlanEmo2DReportData = (ZPlanEmo2DReportData) other;
            return this.errCode == zPlanEmo2DReportData.errCode && this.runnableStartTime == zPlanEmo2DReportData.runnableStartTime && this.downloadTimeCost == zPlanEmo2DReportData.downloadTimeCost && this.encodeTimeCost == zPlanEmo2DReportData.encodeTimeCost && this.realEncode == zPlanEmo2DReportData.realEncode;
        }

        public /* synthetic */ ZPlanEmo2DReportData(int i3, long j3, long j16, long j17, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? 0L : j16, (i16 & 8) == 0 ? j17 : 0L, (i16 & 16) == 0 ? z16 : false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"kh3/c$d", "Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/ZPlanEmoticon2DFactory$a;", "", "bgResDir", "fgResDir", "", "b", "", "errCode", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements ZPlanEmoticon2DFactory.a {

        /* renamed from: a */
        final /* synthetic */ ZPlanActionInfo f412377a;

        /* renamed from: b */
        final /* synthetic */ long f412378b;

        /* renamed from: c */
        final /* synthetic */ String f412379c;

        /* renamed from: d */
        final /* synthetic */ String f412380d;

        /* renamed from: e */
        final /* synthetic */ String f412381e;

        /* renamed from: f */
        final /* synthetic */ String f412382f;

        /* renamed from: g */
        final /* synthetic */ String f412383g;

        /* renamed from: h */
        final /* synthetic */ String f412384h;

        d(ZPlanActionInfo zPlanActionInfo, long j3, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f412377a = zPlanActionInfo;
            this.f412378b = j3;
            this.f412379c = str;
            this.f412380d = str2;
            this.f412381e = str3;
            this.f412382f = str4;
            this.f412383g = str5;
            this.f412384h = str6;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"kh3/c$d$a", "Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DEncoderHelper$a;", "", "code", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements Anim2DEncoderHelper.a {

            /* renamed from: a */
            final /* synthetic */ String f412385a;

            /* renamed from: b */
            final /* synthetic */ String f412386b;

            /* renamed from: c */
            final /* synthetic */ long f412387c;

            /* renamed from: d */
            final /* synthetic */ ZPlanActionInfo f412388d;

            /* renamed from: e */
            final /* synthetic */ String f412389e;

            /* renamed from: f */
            final /* synthetic */ long f412390f;

            /* renamed from: g */
            final /* synthetic */ long f412391g;

            /* renamed from: h */
            final /* synthetic */ String f412392h;

            /* renamed from: i */
            final /* synthetic */ String f412393i;

            a(String str, String str2, long j3, ZPlanActionInfo zPlanActionInfo, String str3, long j16, long j17, String str4, String str5) {
                this.f412385a = str;
                this.f412386b = str2;
                this.f412387c = j3;
                this.f412388d = zPlanActionInfo;
                this.f412389e = str3;
                this.f412390f = j16;
                this.f412391g = j17;
                this.f412392h = str4;
                this.f412393i = str5;
            }

            @Override // com.tencent.mobileqq.zplan.meme.animation2D.Anim2DEncoderHelper.a
            public void a(int code) {
                if (code >= 0) {
                    Anim2DFileCacheUtil.f333892a.e(this.f412392h, this.f412393i);
                }
                long currentTimeMillis = System.currentTimeMillis() - this.f412387c;
                c cVar = c.f412361a;
                String str = this.f412393i;
                ZPlanActionInfo zPlanActionInfo = this.f412388d;
                String str2 = this.f412389e;
                File a16 = Anim2DFileCacheUtil.f333892a.a(str);
                cVar.n(str, code, zPlanActionInfo, str2, a16 != null ? a16.getAbsolutePath() : null, this.f412390f, this.f412391g, currentTimeMillis);
            }

            @Override // com.tencent.mobileqq.zplan.meme.animation2D.Anim2DEncoderHelper.a
            public void b(int code) {
                if (code >= 0) {
                    Anim2DFileCacheUtil.f333892a.e(this.f412385a, this.f412386b);
                }
                long currentTimeMillis = System.currentTimeMillis() - this.f412387c;
                c cVar = c.f412361a;
                String str = this.f412386b;
                ZPlanActionInfo zPlanActionInfo = this.f412388d;
                String str2 = this.f412389e;
                File a16 = Anim2DFileCacheUtil.f333892a.a(str);
                cVar.n(str, code, zPlanActionInfo, str2, a16 != null ? a16.getAbsolutePath() : null, this.f412390f, this.f412391g, currentTimeMillis);
            }
        }

        @Override // com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory.a
        public void a(int errCode, String errMsg) {
            QLog.e("ZPlanEmoticon2DManager", 1, "realEncodeEmotion2D onGetResFailed, id: " + this.f412377a.getId() + ", name: " + this.f412377a.getName() + ", errCode: " + errCode + ", errMsg: " + errMsg);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f412378b;
            long j16 = currentTimeMillis - j3;
            c cVar = c.f412361a;
            cVar.n(this.f412382f, -18018, this.f412377a, this.f412383g, null, j3, j16, 0L);
            cVar.n(this.f412384h, -18018, this.f412377a, this.f412383g, null, this.f412378b, j16, 0L);
        }

        @Override // com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory.a
        public void b(String bgResDir, String fgResDir) {
            QLog.i("ZPlanEmoticon2DManager", 1, "onGetResSuccess, id: " + this.f412377a.getId() + ", name: " + this.f412377a.getName() + ", bgResDir: " + bgResDir + ", fgResDir: " + fgResDir);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.f412378b;
            Anim2DRecordData anim2DRecordData = new Anim2DRecordData(this.f412377a.getId(), this.f412377a.getWidth(), this.f412377a.getHeight(), c.f412361a.i(this.f412377a), this.f412379c, (float) ViewUtils.dpToPx(ZPlanFeatureSwitch.f369852a.h()), MODE.GIF, com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.g(), bgResDir, fgResDir, null, null, this.f412377a.getEncodeWidth(), this.f412377a.getEncodeHeight());
            anim2DRecordData.o(this.f412380d);
            anim2DRecordData.p(this.f412381e);
            Anim2DEncoderHelper.f333888a.h(anim2DRecordData, true, new a(this.f412380d, this.f412382f, currentTimeMillis, this.f412377a, this.f412383g, this.f412378b, j3, this.f412381e, this.f412384h));
        }
    }

    c() {
    }

    private final Runnable g(final String keyCover, final String keyGif, final ZPlanActionInfo actionInfo, final String selfUin, final String avatarPath) {
        return new Runnable() { // from class: kh3.a
            @Override // java.lang.Runnable
            public final void run() {
                c.h(keyCover, keyGif, actionInfo, selfUin, avatarPath);
            }
        };
    }

    public final int i(ZPlanActionInfo actionInfo) {
        int frameRate = actionInfo.getEmo2DInfo().getFrameRate();
        if (frameRate == 0) {
            return 30;
        }
        return frameRate;
    }

    private final Runnable j(final String key, final ZPlanActionInfo actionInfo, final String selfUin, final String avatarPath, final MODE mode) {
        return new Runnable() { // from class: kh3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.k(key, mode, actionInfo, selfUin, avatarPath);
            }
        };
    }

    public final int l(Anim2DRecordData data) {
        String bgResDir = data.getBgResDir();
        boolean z16 = true;
        if (bgResDir == null || bgResDir.length() == 0) {
            String fgResDir = data.getFgResDir();
            if (fgResDir != null && fgResDir.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return com.tencent.zplan.common.utils.c.f385288a.b(data.getAvatarPath(), data.getCoverPath()) ? 0 : -18002;
            }
        }
        return Anim2DEncoderHelper.f333888a.g(data);
    }

    public final int m(Anim2DRecordData anim2DRecordData) {
        String bgResDir = anim2DRecordData.getBgResDir();
        boolean z16 = true;
        if (bgResDir == null || bgResDir.length() == 0) {
            String fgResDir = anim2DRecordData.getFgResDir();
            if (fgResDir != null && fgResDir.length() != 0) {
                z16 = false;
            }
            if (z16) {
                int i3 = anim2DRecordData.getMode() == MODE.SHARPP ? -18004 : -18014;
                String picPath = anim2DRecordData.getPicPath();
                if (picPath == null || TextUtils.isEmpty(anim2DRecordData.getCacheDir())) {
                    return i3;
                }
                Anim2DEncoderHelper anim2DEncoderHelper = Anim2DEncoderHelper.f333888a;
                int id5 = anim2DRecordData.getId();
                int width = anim2DRecordData.getWidth();
                int height = anim2DRecordData.getHeight();
                MODE mode = anim2DRecordData.getMode();
                String avatarPath = anim2DRecordData.getAvatarPath();
                String cacheDir = anim2DRecordData.getCacheDir();
                Intrinsics.checkNotNull(cacheDir);
                return anim2DEncoderHelper.c(id5, width, height, mode, avatarPath, picPath, cacheDir, anim2DRecordData.getRadius());
            }
        }
        return Anim2DEncoderHelper.f333888a.h(anim2DRecordData, false, null);
    }

    private final void p(ZPlanActionInfo actionInfo, String selfUin, String avatarPath, MODE mode, b listener) {
        String b16 = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.b(actionInfo, mode, selfUin);
        QLog.i("ZPlanEmoticon2DManager", 1, "realEncodeEmotion2D, key: " + b16 + ", mode: " + mode + ", info:" + actionInfo);
        CopyOnWriteArrayList<String> copyOnWriteArrayList = encodingKeyList;
        if (copyOnWriteArrayList.contains(b16)) {
            v(b16, listener);
            QLog.i("ZPlanEmoticon2DManager", 1, "realEncodeEmotion2D, key: " + b16 + " encoding, return.");
            return;
        }
        copyOnWriteArrayList.add(b16);
        v(b16, listener);
        u(j(b16, actionInfo, selfUin, avatarPath, mode));
    }

    private final void v(String key, b listener) {
        ReentrantLock reentrantLock = org.aspectj.lang.JoinPoint.SYNCHRONIZATION_LOCK java.lang.String;
        reentrantLock.lock();
        try {
            encodingKeyListenerMap.put(key, listener);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void w(String key, boolean success, String retPath, ZPlanEmo2DReportData reportData) {
        ReentrantLock reentrantLock = org.aspectj.lang.JoinPoint.SYNCHRONIZATION_LOCK java.lang.String;
        reentrantLock.lock();
        try {
            ConcurrentHashMap<String, b> concurrentHashMap = encodingKeyListenerMap;
            if (concurrentHashMap.containsKey(key)) {
                b bVar = concurrentHashMap.get(key);
                if (bVar != null) {
                    bVar.a(success, retPath, reportData);
                }
                concurrentHashMap.remove(key);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void o() {
        encodingKeyListenerMap.clear();
    }

    public final void q(String avatarPath, ZPlanActionInfo actionInfo, String selfUin, long j3, jh3.b bVar, ZPlanEmoticonReportData recordReportData) {
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(recordReportData, "recordReportData");
        MODE mode = MODE.FRAME;
        p(actionInfo, selfUin, avatarPath, mode, new a(bVar, actionInfo, selfUin, mode, j3, recordReportData));
    }

    public final void t(String avatarPath, ZPlanActionInfo actionInfo, String selfUin, long startTime, jh3.b listener, ZPlanEmoticonReportData recordReportData) {
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(recordReportData, "recordReportData");
        p(actionInfo, selfUin, avatarPath, actionInfo.getPic2DMode(), new a(listener, actionInfo, selfUin, actionInfo.getPic2DMode(), startTime, recordReportData));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"kh3/c$e", "Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/ZPlanEmoticon2DFactory$a;", "", "bgResDir", "fgResDir", "", "b", "", "errCode", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e implements ZPlanEmoticon2DFactory.a {

        /* renamed from: a */
        final /* synthetic */ ZPlanActionInfo f412394a;

        /* renamed from: b */
        final /* synthetic */ long f412395b;

        /* renamed from: c */
        final /* synthetic */ String f412396c;

        /* renamed from: d */
        final /* synthetic */ MODE f412397d;

        /* renamed from: e */
        final /* synthetic */ String f412398e;

        /* renamed from: f */
        final /* synthetic */ String f412399f;

        /* renamed from: g */
        final /* synthetic */ String f412400g;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes38.dex */
        public /* synthetic */ class a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f412401a;

            static {
                int[] iArr = new int[MODE.values().length];
                try {
                    iArr[MODE.FRAME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MODE.SHARPP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MODE.GIF.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f412401a = iArr;
            }
        }

        e(ZPlanActionInfo zPlanActionInfo, long j3, String str, MODE mode, String str2, String str3, String str4) {
            this.f412394a = zPlanActionInfo;
            this.f412395b = j3;
            this.f412396c = str;
            this.f412397d = mode;
            this.f412398e = str2;
            this.f412399f = str3;
            this.f412400g = str4;
        }

        @Override // com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory.a
        public void a(int errCode, String errMsg) {
            QLog.e("ZPlanEmoticon2DManager", 1, "realEncodeEmotion2D onGetResFailed, id: " + this.f412394a.getId() + ", name: " + this.f412394a.getName() + ", errCode: " + errCode + ", errMsg: " + errMsg);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f412395b;
            c.f412361a.n(this.f412399f, -18018, this.f412394a, this.f412400g, null, j3, currentTimeMillis - j3, 0L);
        }

        @Override // com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory.a
        public void b(String bgResDir, String fgResDir) {
            c cVar;
            int l3;
            QLog.i("ZPlanEmoticon2DManager", 1, "onGetResSuccess, id: " + this.f412394a.getId() + ", name: " + this.f412394a.getName() + ", bgResDir: " + bgResDir + ", fgResDir: " + fgResDir);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.f412395b;
            float dpToPx = (float) ViewUtils.dpToPx(ZPlanFeatureSwitch.f369852a.h());
            int id5 = this.f412394a.getId();
            int width = this.f412394a.getWidth();
            int height = this.f412394a.getHeight();
            c cVar2 = c.f412361a;
            Anim2DRecordData anim2DRecordData = new Anim2DRecordData(id5, width, height, cVar2.i(this.f412394a), this.f412396c, dpToPx, this.f412397d, com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.g(), bgResDir, fgResDir, null, null, this.f412394a.getEncodeWidth(), this.f412394a.getEncodeHeight());
            int i3 = a.f412401a[this.f412397d.ordinal()];
            if (i3 == 1) {
                cVar = cVar2;
                anim2DRecordData.o(this.f412398e);
                l3 = cVar.l(anim2DRecordData);
            } else if (i3 != 2 && i3 != 3) {
                QLog.e("ZPlanEmoticon2DManager", 1, "mode: " + this.f412397d + ", is not support");
                l3 = -1001;
                cVar = cVar2;
            } else {
                anim2DRecordData.p(this.f412398e);
                cVar = cVar2;
                l3 = cVar.m(anim2DRecordData);
            }
            QLog.i("ZPlanEmoticon2DManager", 1, "realEncode runnable after encode, mode: " + this.f412397d + ", ret: " + l3 + ", retPath: " + this.f412398e + ", actionInfo: " + this.f412394a);
            if (l3 >= 0) {
                Anim2DFileCacheUtil.f333892a.e(this.f412398e, this.f412399f);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String str = this.f412399f;
            ZPlanActionInfo zPlanActionInfo = this.f412394a;
            String str2 = this.f412400g;
            File a16 = Anim2DFileCacheUtil.f333892a.a(str);
            cVar.n(str, l3, zPlanActionInfo, str2, a16 != null ? a16.getAbsolutePath() : null, this.f412395b, j3, currentTimeMillis2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010+\u001a\u00020&\u00a2\u0006\u0004\b/\u00100J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010.\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010$\u00a8\u00061"}, d2 = {"Lkh3/c$a;", "Lkh3/c$b;", "", "success", "", "path", "Lkh3/c$c;", "data", "", "a", "Ljh3/b;", "Ljh3/b;", "getListener", "()Ljh3/b;", "listener", "Lcom/tencent/mobileqq/zplan/model/e;", "b", "Lcom/tencent/mobileqq/zplan/model/e;", "getActionInfo", "()Lcom/tencent/mobileqq/zplan/model/e;", "actionInfo", "c", "Ljava/lang/String;", "getSelfUin", "()Ljava/lang/String;", "selfUin", "Lcom/tencent/zplan/meme/action/MODE;", "d", "Lcom/tencent/zplan/meme/action/MODE;", "getMode", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "e", "J", "getStartTime", "()J", "startTime", "Lnh3/b;", "f", "Lnh3/b;", "getRecordReportData", "()Lnh3/b;", "recordReportData", "g", "getListenerTime", "listenerTime", "<init>", "(Ljh3/b;Lcom/tencent/mobileqq/zplan/model/e;Ljava/lang/String;Lcom/tencent/zplan/meme/action/MODE;JLnh3/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements b {

        /* renamed from: a, reason: from kotlin metadata */
        private final jh3.b listener;

        /* renamed from: b, reason: from kotlin metadata */
        private final ZPlanActionInfo actionInfo;

        /* renamed from: c, reason: from kotlin metadata */
        private final String selfUin;

        /* renamed from: d, reason: from kotlin metadata */
        private final MODE mode;

        /* renamed from: e, reason: from kotlin metadata */
        private final long startTime;

        /* renamed from: f, reason: from kotlin metadata */
        private final ZPlanEmoticonReportData recordReportData;

        /* renamed from: g, reason: from kotlin metadata */
        private final long listenerTime;

        public a(jh3.b bVar, ZPlanActionInfo actionInfo, String selfUin, MODE mode, long j3, ZPlanEmoticonReportData recordReportData) {
            Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
            Intrinsics.checkNotNullParameter(selfUin, "selfUin");
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(recordReportData, "recordReportData");
            this.listener = bVar;
            this.actionInfo = actionInfo;
            this.selfUin = selfUin;
            this.mode = mode;
            this.startTime = j3;
            this.recordReportData = recordReportData;
            this.listenerTime = System.currentTimeMillis();
        }

        @Override // kh3.c.b
        public void a(boolean success, String path, ZPlanEmo2DReportData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("ZPlanEmoticon2DManager", 1, "encode IEmo2DRetListener listenerCost: " + (System.currentTimeMillis() - this.listenerTime) + ", id: " + this.actionInfo.getId() + ", name: " + this.actionInfo.getName() + ", mode: " + this.mode + ", data: " + data);
            ZPlanEmoticonReportData zPlanEmoticonReportData = new ZPlanEmoticonReportData(data.getErrCode(), this.recordReportData.getRecorderType(), this.recordReportData.getRecordStartEngineTime(), this.recordReportData.getRecordQueueTime(), this.recordReportData.getRecordTime(), this.recordReportData.getRecordCache(), this.recordReportData.getRecordMode(), Math.max(data.getRunnableStartTime() - this.listenerTime, 0L), data.getEncodeTimeCost(), data.getDownloadTimeCost(), this.mode, false, 0, 4096, null);
            jh3.b bVar = this.listener;
            if (bVar != null) {
                bVar.a(success, path, zPlanEmoticonReportData, this.mode);
            }
            if (data.getRealEncode()) {
                com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.o(this.actionInfo, this.selfUin, this.mode, this.startTime, zPlanEmoticonReportData);
            }
        }
    }

    private final void u(Runnable runable) {
        ThreadManagerV2.excute(runable, 16, null, true);
    }

    public static final void k(String key, MODE mode, ZPlanActionInfo actionInfo, String selfUin, String avatarPath) {
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(mode, "$mode");
        Intrinsics.checkNotNullParameter(actionInfo, "$actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
        Intrinsics.checkNotNullParameter(avatarPath, "$avatarPath");
        QLog.i("ZPlanEmoticon2DManager", 1, "realEncodeEmotion2D runnable, key: " + key + ", mode: " + mode + ", actionInfo: " + actionInfo);
        com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.c(actionInfo, selfUin, new e(actionInfo, System.currentTimeMillis(), avatarPath, mode, Anim2DFileCacheUtil.f333892a.c(key), key, selfUin));
    }

    public static final void h(String keyCover, String keyGif, ZPlanActionInfo actionInfo, String selfUin, String avatarPath) {
        Intrinsics.checkNotNullParameter(keyCover, "$keyCover");
        Intrinsics.checkNotNullParameter(keyGif, "$keyGif");
        Intrinsics.checkNotNullParameter(actionInfo, "$actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
        Intrinsics.checkNotNullParameter(avatarPath, "$avatarPath");
        long currentTimeMillis = System.currentTimeMillis();
        Anim2DFileCacheUtil anim2DFileCacheUtil = Anim2DFileCacheUtil.f333892a;
        com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.c(actionInfo, selfUin, new d(actionInfo, currentTimeMillis, avatarPath, anim2DFileCacheUtil.c(keyCover), anim2DFileCacheUtil.c(keyGif), keyCover, selfUin, keyGif));
    }

    public final void n(String str, int i3, ZPlanActionInfo zPlanActionInfo, String str2, String str3, long j3, long j16, long j17) {
        QLog.i("ZPlanEmoticon2DManager", 1, "realEncodeEmotion2D handleResult, ret: " + i3 + ", retPath: " + str3);
        encodingKeyList.remove(str);
        ZPlanEmo2DReportData zPlanEmo2DReportData = new ZPlanEmo2DReportData(i3, j3, j16, j17, false, 16, null);
        boolean z16 = i3 == 0;
        zPlanEmo2DReportData.f(false);
        Unit unit = Unit.INSTANCE;
        w(str, z16, str3, zPlanEmo2DReportData);
        ZPlanEmoticon2DFactory.f333159b.i(i3, zPlanActionInfo, str2);
    }

    public final void r(String avatarPath, ZPlanActionInfo actionInfo, String selfUin, long startTime, jh3.b listener, ZPlanEmoticonReportData recordReportData, String recordAppearanceKey, Boolean needRefreshView) {
        boolean z16;
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(recordReportData, "recordReportData");
        Intrinsics.checkNotNullParameter(recordAppearanceKey, "recordAppearanceKey");
        MODE mode = MODE.FRAME;
        a aVar = new a(listener, actionInfo, selfUin, mode, startTime, recordReportData);
        a aVar2 = new a(listener, actionInfo, selfUin, actionInfo.getPic2DMode(), startTime, recordReportData);
        boolean z17 = true;
        if (!(recordAppearanceKey.length() > 0) || ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).checkAppearanceKeyUpToDate(recordAppearanceKey, selfUin)) {
            com.tencent.mobileqq.zplan.emoticon.panel.util.a aVar3 = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a;
            String b16 = aVar3.b(actionInfo, mode, selfUin);
            String b17 = aVar3.b(actionInfo, MODE.GIF, selfUin);
            CopyOnWriteArrayList<String> copyOnWriteArrayList = encodingKeyList;
            if (copyOnWriteArrayList.contains(b16)) {
                z16 = false;
            } else {
                copyOnWriteArrayList.add(b16);
                z16 = true;
            }
            if (Intrinsics.areEqual(needRefreshView, Boolean.TRUE)) {
                v(b16, aVar);
            }
            if (copyOnWriteArrayList.contains(b17)) {
                z17 = false;
            } else {
                copyOnWriteArrayList.add(b17);
            }
            v(b17, aVar2);
            if (z16 && z17) {
                u(g(b16, b17, actionInfo, selfUin, avatarPath));
                return;
            }
            if (!z16 && z17) {
                u(j(b17, actionInfo, selfUin, avatarPath, actionInfo.getPic2DMode()));
            } else {
                if (!z16 || z17) {
                    return;
                }
                u(j(b16, actionInfo, selfUin, avatarPath, mode));
            }
        }
    }
}
