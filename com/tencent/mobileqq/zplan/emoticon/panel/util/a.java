package com.tencent.mobileqq.zplan.emoticon.panel.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory;
import com.tencent.mobileqq.zplan.meme.animation2D.Anim2DFileCacheUtil;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanEmoticon2DAction;
import com.tencent.zplan.utils.ZPlanConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nh3.ZPlanEmoticonReportData;
import t74.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ,\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ,\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ.\u0010\u0012\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bJ.\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0018\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0004J \u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010$R\u0014\u0010'\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/util/a;", "", "Lcom/tencent/mobileqq/zplan/model/e;", "actionInfo", "", "selfUin", "Lcom/tencent/zplan/meme/Priority;", "priority", "Ljh3/b;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "", "actionList2D", "", "reqFrom", "k", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "startTime", "Lnh3/b;", "reportData", "o", "b", "d", "e", "", "i", "j", "g", "uin", "f", h.F, "Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/ZPlanEmoticon2DFactory$a;", "c", "Z", "enableRecordOptimization", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f333231a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableRecordOptimization = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableEmotionRecordOptimization();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$b", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements jh3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jh3.b f333239a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanActionInfo f333240b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f333241c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f333242d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$b$a", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9174a implements jh3.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZPlanActionInfo f333243a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ jh3.b f333244b;

            C9174a(ZPlanActionInfo zPlanActionInfo, jh3.b bVar) {
                this.f333243a = zPlanActionInfo;
                this.f333244b = bVar;
            }

            @Override // jh3.b
            public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(mode, "mode");
                QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DCover, realEncodeEmotion2DCover onGetResource success: " + success + ", path: " + path + ", info:" + this.f333243a + ", data: " + data);
                jh3.b bVar = this.f333244b;
                if (bVar != null) {
                    bVar.a(success, path, data, mode);
                }
            }
        }

        b(jh3.b bVar, ZPlanActionInfo zPlanActionInfo, String str, long j3) {
            this.f333239a = bVar;
            this.f333240b = zPlanActionInfo;
            this.f333241c = str;
            this.f333242d = j3;
        }

        @Override // jh3.b
        public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(mode, "mode");
            if (success && path != null) {
                kh3.c.f412361a.q(path, this.f333240b, this.f333241c, this.f333242d, new C9174a(this.f333240b, this.f333239a), data);
            } else {
                jh3.b bVar = this.f333239a;
                if (bVar != null) {
                    bVar.a(false, null, data, mode);
                }
                a.f333231a.o(this.f333240b, this.f333241c, MODE.FRAME, this.f333242d, data);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$c", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements jh3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jh3.b f333245a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanActionInfo f333246b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f333247c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f333248d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f333249e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$c$a", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9175a implements jh3.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZPlanActionInfo f333250a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ jh3.b f333251b;

            C9175a(ZPlanActionInfo zPlanActionInfo, jh3.b bVar) {
                this.f333250a = zPlanActionInfo;
                this.f333251b = bVar;
            }

            @Override // jh3.b
            public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(mode, "mode");
                QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DCover, realEncodeEmotion2DCover onGetResource success: " + success + ", path: " + path + ", info:" + this.f333250a + ", data: " + data);
                jh3.b bVar = this.f333251b;
                if (bVar != null) {
                    bVar.a(success, path, data, mode);
                }
            }
        }

        c(jh3.b bVar, ZPlanActionInfo zPlanActionInfo, String str, long j3, String str2) {
            this.f333245a = bVar;
            this.f333246b = zPlanActionInfo;
            this.f333247c = str;
            this.f333248d = j3;
            this.f333249e = str2;
        }

        @Override // jh3.b
        public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(mode, "mode");
            if (success && path != null) {
                kh3.c.f412361a.r(path, this.f333246b, this.f333247c, this.f333248d, new C9175a(this.f333246b, this.f333245a), data, this.f333249e, Boolean.TRUE);
            } else {
                jh3.b bVar = this.f333245a;
                if (bVar != null) {
                    bVar.a(false, null, data, mode);
                }
                a.f333231a.o(this.f333246b, this.f333247c, MODE.FRAME, this.f333248d, data);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$d", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements jh3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZPlanActionInfo f333252a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jh3.b f333253b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f333254c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f333255d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$d$a", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9176a implements jh3.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZPlanActionInfo f333256a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ jh3.b f333257b;

            C9176a(ZPlanActionInfo zPlanActionInfo, jh3.b bVar) {
                this.f333256a = zPlanActionInfo;
                this.f333257b = bVar;
            }

            @Override // jh3.b
            public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(mode, "mode");
                QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DPic, realEncodeEmotion2DPic onGetResource success: " + success + ", path: " + path + ", info:" + this.f333256a + ",  data: " + data);
                jh3.b bVar = this.f333257b;
                if (bVar != null) {
                    bVar.a(success, path, data, mode);
                }
            }
        }

        d(ZPlanActionInfo zPlanActionInfo, jh3.b bVar, String str, long j3) {
            this.f333252a = zPlanActionInfo;
            this.f333253b = bVar;
            this.f333254c = str;
            this.f333255d = j3;
        }

        @Override // jh3.b
        public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(mode, "mode");
            QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DPic, recordAction onGetResource success: " + success + ", path: " + path + ", info:" + this.f333252a + ", data: " + data);
            if (success && path != null) {
                kh3.c.f412361a.t(path, this.f333252a, this.f333254c, this.f333255d, new C9176a(this.f333252a, this.f333253b), data);
            } else {
                jh3.b bVar = this.f333253b;
                if (bVar != null) {
                    bVar.a(false, null, data, mode);
                }
                a.f333231a.o(this.f333252a, this.f333254c, MODE.SHARPP, this.f333255d, data);
            }
        }
    }

    a() {
    }

    public final void c(ZPlanActionInfo actionInfo, String uin, ZPlanEmoticon2DFactory.a listener) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZPlanEmoticon2DFactory.f333159b.h(actionInfo, uin, listener);
    }

    public final String d(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        File a16 = Anim2DFileCacheUtil.f333892a.a(b(actionInfo, MODE.FRAME, selfUin));
        if (a16 == null || !a16.exists()) {
            return null;
        }
        return a16.getAbsolutePath();
    }

    public final String e(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        File a16 = Anim2DFileCacheUtil.f333892a.a(b(actionInfo, actionInfo.getPic2DMode(), selfUin));
        if (a16 == null || !a16.exists()) {
            return null;
        }
        return a16.getAbsolutePath();
    }

    public final String f(ZPlanActionInfo actionInfo, String uin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (bb.f335811a.o(uin) == 1) {
            return actionInfo.getEmo2DInfo().getMale2DZipUrl();
        }
        return actionInfo.getEmo2DInfo().getFemale2DZipUrl();
    }

    public final String g() {
        return ZPlanConstant.f386195f.a();
    }

    public final boolean h(ZPlanActionInfo actionInfo, String uin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return !TextUtils.isEmpty(f(actionInfo, uin));
    }

    public final boolean i(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return d(actionInfo, selfUin) != null;
    }

    public final boolean j(ZPlanActionInfo actionInfo, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return e(actionInfo, selfUin) != null;
    }

    public final void o(ZPlanActionInfo actionInfo, String selfUin, MODE mode, long startTime, ZPlanEmoticonReportData reportData) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        String t16 = ZPlanEmoticonUtil.f333176e.t(actionInfo, selfUin, mode);
        String b16 = b(actionInfo, mode, selfUin);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("emoticon_2d_id", String.valueOf(actionInfo.getId()));
        linkedHashMap.put("emoticon_2d_error_code", String.valueOf(reportData.getErrCode()));
        linkedHashMap.put("emoticon_2d_record_key", t16);
        linkedHashMap.put("emoticon_2d_record_type", reportData.getRecorderType());
        linkedHashMap.put("emoticon_2d_start_engine_time_cost", String.valueOf(reportData.getRecordStartEngineTime()));
        linkedHashMap.put("emoticon_2d_record_queue_time_cost", String.valueOf(reportData.getRecordQueueTime()));
        linkedHashMap.put("emoticon_2d_record_time_cost", String.valueOf(reportData.getRecordTime()));
        linkedHashMap.put("emoticon_2d_record_cache", String.valueOf(reportData.getRecordCache()));
        linkedHashMap.put("emoticon_2d_encode_key", b16);
        linkedHashMap.put("emoticon_2d_encode_queue_time_cost", String.valueOf(reportData.getEncode2DQueueTime()));
        linkedHashMap.put("emoticon_2d_encode_download_time_cost", String.valueOf(reportData.getEncodeDownloadTime()));
        linkedHashMap.put("emoticon_2d_encode_mode", reportData.getEncode2DMode().toString());
        linkedHashMap.put("emoticon_2d_encode_cost", String.valueOf(reportData.getEncode2DTime()));
        linkedHashMap.put("emoticon_2d_encode_cache", String.valueOf(reportData.getEncodeCache()));
        linkedHashMap.put("emoticon_2d_total_cost", String.valueOf(System.currentTimeMillis() - startTime));
        linkedHashMap.put("emoticon_2d_user_id", selfUin);
        r.e(null, "zplan_emoticon_2d_all_encode", linkedHashMap, 1, null);
    }

    public final String b(ZPlanActionInfo actionInfo, MODE mode, String selfUin) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        int width = actionInfo.getWidth();
        int height = actionInfo.getHeight();
        String name = actionInfo.getName();
        if (name == null) {
            name = String.valueOf(actionInfo.getId());
        }
        String f16 = f(actionInfo, selfUin);
        return new MemeZPlanEmoticon2DAction(actionInfo.getId(), mode.toFrameCount(), width, height, mode, selfUin, null, name, null, f16, null, null, null, null, 15616, null).getKey();
    }

    public final void l(ZPlanActionInfo actionInfo, String selfUin, Priority priority, jh3.b listener) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(priority, "priority");
        String d16 = d(actionInfo, selfUin);
        if (d16 != null) {
            QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DCover, get catch " + d16 + ", info=" + actionInfo);
            if (listener != null) {
                MODE mode = MODE.FRAME;
                listener.a(true, d16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, mode, true, 0, 5118, null), mode);
                return;
            }
            return;
        }
        ZPlanEmoticonUtil.f333176e.L(actionInfo, MODE.FRAME, selfUin, priority, new b(listener, actionInfo, selfUin, System.currentTimeMillis()));
    }

    public final void n(ZPlanActionInfo actionInfo, String selfUin, Priority priority, jh3.b listener) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(priority, "priority");
        QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DPic, actionInfo: " + actionInfo);
        String e16 = e(actionInfo, selfUin);
        if (e16 != null) {
            QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DPic, get catch " + e16);
            if (listener != null) {
                listener.a(true, e16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, actionInfo.getPic2DMode(), true, 0, 5118, null), MODE.GIF);
                return;
            }
            return;
        }
        ZPlanEmoticonUtil.f333176e.L(actionInfo, MODE.FRAME, selfUin, priority, new d(actionInfo, listener, selfUin, System.currentTimeMillis()));
    }

    public final void k(List<ZPlanActionInfo> actionList2D, String selfUin, int reqFrom, jh3.b listener) {
        List reversed;
        Intrinsics.checkNotNullParameter(actionList2D, "actionList2D");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        ArrayList arrayList = new ArrayList();
        QRouteApi api = QRoute.api(IZPlanDataHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanDataHelper::class.java)");
        IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) api;
        for (ZPlanActionInfo zPlanActionInfo : actionList2D) {
            String d16 = d(zPlanActionInfo, selfUin);
            String e16 = e(zPlanActionInfo, selfUin);
            if (d16 != null && e16 != null) {
                QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2D, get catchCoverPath " + d16 + ", catchPicPath: " + e16 + ", info=" + zPlanActionInfo);
                if (listener != null) {
                    MODE mode = MODE.FRAME;
                    listener.a(true, d16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, mode, true, 0, 5118, null), mode);
                }
                if (listener != null) {
                    listener.a(true, e16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, zPlanActionInfo.getPic2DMode(), true, 0, 5118, null), zPlanActionInfo.getPic2DMode());
                }
            } else {
                arrayList.add(zPlanActionInfo);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        C9172a c9172a = new C9172a(listener, selfUin, System.currentTimeMillis(), iZPlanDataHelper);
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        reversed = CollectionsKt___CollectionsKt.reversed(arrayList);
        ZPlanEmoticonUtil.W(zPlanEmoticonUtil, reversed, selfUin, Priority.MIDDLE, Priority.LOW, reqFrom, c9172a, null, 64, null);
    }

    public final void m(ZPlanActionInfo actionInfo, String selfUin, Priority priority, jh3.b listener) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(priority, "priority");
        QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2DCover, actionInfo: " + actionInfo);
        String d16 = d(actionInfo, selfUin);
        String e16 = e(actionInfo, selfUin);
        if (d16 != null && e16 == null) {
            n(actionInfo, selfUin, priority, listener);
            if (listener != null) {
                MODE mode = MODE.FRAME;
                listener.a(true, d16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, mode, true, 0, 5118, null), mode);
                return;
            }
            return;
        }
        if (d16 == null && e16 != null) {
            l(actionInfo, selfUin, priority, listener);
            if (listener != null) {
                listener.a(true, e16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, MODE.FRAME, true, 0, 5118, null), MODE.GIF);
                return;
            }
            return;
        }
        if (d16 == null || e16 == null) {
            ZPlanEmoticonUtil.f333176e.L(actionInfo, MODE.FRAME, selfUin, priority, new c(listener, actionInfo, selfUin, System.currentTimeMillis(), ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(selfUin).appearanceKey));
        } else {
            if (listener != null) {
                MODE mode2 = MODE.FRAME;
                listener.a(true, d16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, mode2, true, 0, 5118, null), mode2);
            }
            if (listener != null) {
                listener.a(true, e16, new ZPlanEmoticonReportData(0, null, 0L, 0L, 0L, false, null, 0L, 0L, 0L, MODE.FRAME, true, 0, 5118, null), MODE.GIF);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$a", "Ljh3/a;", "", "success", "", "path", "Lcom/tencent/mobileqq/zplan/model/e;", "actionInfo", "Lnh3/b;", "data", "recordAppearanceKey", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9172a implements jh3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jh3.b f333233a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f333234b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f333235c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IZPlanDataHelper f333236d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/panel/util/a$a$a", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.emoticon.panel.util.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9173a implements jh3.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZPlanActionInfo f333237a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ jh3.b f333238b;

            C9173a(ZPlanActionInfo zPlanActionInfo, jh3.b bVar) {
                this.f333237a = zPlanActionInfo;
                this.f333238b = bVar;
            }

            @Override // jh3.b
            public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(mode, "mode");
                QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2D, recordEmoticon2D onGetResource success: " + success + ", path: " + path + ", info:" + this.f333237a + ",  data: " + data);
                jh3.b bVar = this.f333238b;
                if (bVar != null) {
                    bVar.a(success, path, data, mode);
                }
            }
        }

        C9172a(jh3.b bVar, String str, long j3, IZPlanDataHelper iZPlanDataHelper) {
            this.f333233a = bVar;
            this.f333234b = str;
            this.f333235c = j3;
            this.f333236d = iZPlanDataHelper;
        }

        @Override // jh3.a
        public void a(boolean success, String path, ZPlanActionInfo actionInfo, ZPlanEmoticonReportData data, String recordAppearanceKey) {
            Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(recordAppearanceKey, "recordAppearanceKey");
            QLog.i("ZPlanEmoticon2DUtil", 1, "recordEmoticon2D, recordAction onGetResource success: " + success + ", path: " + path + ", info:" + actionInfo + ", data: " + data);
            if (success) {
                if (!(path == null || path.length() == 0)) {
                    if ((recordAppearanceKey.length() > 0) && !this.f333236d.checkAppearanceKeyUpToDate(recordAppearanceKey, this.f333234b)) {
                        QLog.i("ZPlanEmoticon2DUtil", 1, "check before recordEmoticon2D, appearanceKey diff, recordKey: " + recordAppearanceKey);
                        a.f333231a.o(actionInfo, this.f333234b, data.getEncode2DMode(), this.f333235c, data);
                        return;
                    }
                    QLog.i("ZPlanEmoticon2DUtil", 1, "check before recordEmoticon2D, appearanceKey same, try record and encode, recordKey: " + recordAppearanceKey);
                    C9173a c9173a = new C9173a(actionInfo, this.f333233a);
                    if (a.enableRecordOptimization) {
                        kh3.c.s(kh3.c.f412361a, path, actionInfo, this.f333234b, this.f333235c, c9173a, data, recordAppearanceKey, null, 128, null);
                        return;
                    }
                    kh3.c cVar = kh3.c.f412361a;
                    cVar.q(path, actionInfo, this.f333234b, this.f333235c, c9173a, data);
                    cVar.t(path, actionInfo, this.f333234b, this.f333235c, c9173a, data);
                    return;
                }
            }
            jh3.b bVar = this.f333233a;
            if (bVar != null) {
                bVar.a(false, null, data, data.getEncode2DMode());
            }
            a.f333231a.o(actionInfo, this.f333234b, data.getEncode2DMode(), this.f333235c, data);
        }
    }
}
