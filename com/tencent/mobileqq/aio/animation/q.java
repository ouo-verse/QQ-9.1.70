package com.tencent.mobileqq.aio.animation;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.animation.api.IAIOAnimationMsgManager;
import com.tencent.mobileqq.aio.animation.business.DragonKingEggsPlayer;
import com.tencent.mobileqq.aio.animation.config.e;
import com.tencent.mobileqq.aio.animation.util.AioAnimationConfigHolder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \\2\u00020\u0001:\u0001JB\t\b\u0002\u00a2\u0006\u0004\bZ\u0010[J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J.\u0010\u0013\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J.\u0010\u0017\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J@\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002JX\u0010(\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\rH\u0002JP\u0010,\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020%2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\rH\u0002J`\u00100\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010.\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\r2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010/\u001a\u00020%H\u0002J\u0012\u00103\u001a\u0004\u0018\u0001022\u0006\u00101\u001a\u00020%H\u0002JX\u00104\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\r2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010/\u001a\u00020%H\u0002J0\u00105\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0002J0\u00106\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J0\u00107\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J:\u0010;\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\u0018\u0010=\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J \u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010@\u001a\u00020\u0007H\u0002J \u0010B\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u0002H\u0002J4\u0010D\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\rJ$\u0010E\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u0005J0\u0010F\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010G\u001a\u00020\u0007J\u0006\u0010H\u001a\u00020\u0007R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010W\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010VR\u0016\u0010Y\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010<\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/q;", "", "Lcom/tencent/mobileqq/aio/animation/data/d;", SessionDbHelper.SESSION_ID, "", "Lcom/tencent/mobileqq/aio/animation/data/b;", TabPreloadItem.TAB_NAME_MESSAGE, "", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", UserInfo.SEX_FEMALE, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "lastParsedMsgSeq", "Lcom/tencent/mobileqq/aio/animation/api/IAIOAnimationMsgManager;", "msgManger", "Z", "E", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "animContainer", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/animation/config/a;", "Lkotlin/collections/ArrayList;", "rules", "B", "I", HippyTKDListViewAdapter.X, TransferConfig.ExtendParamFloats.KEY_RULE, "v", "rulesMatched", "troopOrDiscussion", "message", "checkCombo", "", "delayTimeBase", "isNewMsg", "T", "X", "M", "Y", "o", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "delayTime", "index", "y", "type", "Lcom/tencent/mobileqq/aio/animation/egg/c;", "G", "P", "W", "N", "L", "Landroid/graphics/drawable/Drawable;", "d", "delay", "V", "J", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isC2C", ExifInterface.LATITUDE_SOUTH, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "sessionInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "forceUpdateMsgSeq", "H", "K", "U", DomainData.DOMAIN_NAME, "w", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mHasWebToolsStart", "Lv71/a;", "b", "Lv71/a;", "interceptPart", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "uiHandler", "", "Ljava/util/List;", "mEggBizPlayers", "e", "lastPrintLogTime", "<init>", "()V", "f", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class q {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private static q f188149g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean mHasWebToolsStart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final v71.a interceptPart;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.aio.animation.egg.c> mEggBizPlayers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastPrintLogTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/q$a;", "", "Lcom/tencent/mobileqq/aio/animation/q;", "a", "()Lcom/tencent/mobileqq/aio/animation/q;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "b", "instanceNoCreate", "", "DELAY_TIME", "I", "", "TAG", "Ljava/lang/String;", "sInstance", "Lcom/tencent/mobileqq/aio/animation/q;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.q$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final q a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (q) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (q.f188149g == null) {
                synchronized (q.class) {
                    if (q.f188149g == null) {
                        q.f188149g = new q(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            q qVar = q.f188149g;
            Intrinsics.checkNotNull(qVar);
            return qVar;
        }

        @Nullable
        public final q b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return q.f188149g;
            }
            return (q) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29139);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ q(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
    }

    private final synchronized void A(com.tencent.mobileqq.aio.animation.data.b message, BaseQQAppInterface app, com.tencent.mobileqq.aio.animation.data.d sessionInfo) {
        I();
        List<com.tencent.mobileqq.aio.animation.egg.c> list = this.mEggBizPlayers;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.aio.animation.egg.c) it.next()).b(message, app, sessionInfo);
            }
        }
    }

    private final ArrayList<com.tencent.mobileqq.aio.animation.config.a> B(com.tencent.mobileqq.aio.animation.data.d session, ArrayList<com.tencent.mobileqq.aio.animation.config.a> rules) {
        if (rules == null) {
            return null;
        }
        ArrayList<com.tencent.mobileqq.aio.animation.config.a> arrayList = new ArrayList<>();
        for (com.tencent.mobileqq.aio.animation.config.a aVar : rules) {
            if (session.a(aVar.r())) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private final void C(com.tencent.mobileqq.aio.animation.data.d session, List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList) {
        if (msgList.isEmpty()) {
            return;
        }
        ((IAIOAnimationMsgManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IAIOAnimationMsgManager.class, "")).setParsedMsgSeq(session.b(), D(msgList).getMsgSeq());
    }

    private final com.tencent.mobileqq.aio.animation.data.b D(List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList) {
        Object last;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) msgList);
        for (com.tencent.mobileqq.aio.animation.data.b bVar : msgList) {
            if (bVar.getMsgSeq() > ((com.tencent.mobileqq.aio.animation.data.b) last).getMsgSeq()) {
                last = bVar;
            }
        }
        return (com.tencent.mobileqq.aio.animation.data.b) last;
    }

    private final long E(List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList) {
        long j3 = 0;
        for (com.tencent.mobileqq.aio.animation.data.b bVar : msgList) {
            if (bVar.getMsgSeq() > j3) {
                j3 = bVar.getMsgSeq();
            }
        }
        return j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized List<com.tencent.mobileqq.aio.animation.data.b> F(BaseQQAppInterface app, List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList, com.tencent.mobileqq.aio.animation.data.d session) {
        Object first;
        Object last;
        boolean z16;
        if (msgList.isEmpty()) {
            return msgList;
        }
        IRuntimeService runtimeService = app.getRuntimeService(IAIOAnimationMsgManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IA\u2026va, ProcessConstant.MAIN)");
        IAIOAnimationMsgManager iAIOAnimationMsgManager = (IAIOAnimationMsgManager) runtimeService;
        long latestParsedMsgSeq = iAIOAnimationMsgManager.getLatestParsedMsgSeq(session.b());
        Z(msgList, latestParsedMsgSeq, iAIOAnimationMsgManager, session);
        ArrayList arrayList = new ArrayList();
        for (Object obj : msgList) {
            com.tencent.mobileqq.aio.animation.data.b bVar = (com.tencent.mobileqq.aio.animation.data.b) obj;
            if (bVar.getMsgSeq() > latestParsedMsgSeq && bVar.f()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty() && m()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgList);
            long msgSeq = ((com.tencent.mobileqq.aio.animation.data.b) first).getMsgSeq();
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) msgList);
            QLog.d("AioAnimationDetector", 4, "[getMessageListForParsing] filtered msg list is empty, lastParsedMsgSeq=" + latestParsedMsgSeq + " msgSeq=" + msgSeq + "-" + ((com.tencent.mobileqq.aio.animation.data.b) last).getMsgSeq());
        }
        return arrayList;
    }

    private final synchronized com.tencent.mobileqq.aio.animation.egg.c G(int type) {
        List<com.tencent.mobileqq.aio.animation.egg.c> list = this.mEggBizPlayers;
        if (list != null) {
            for (com.tencent.mobileqq.aio.animation.egg.c cVar : list) {
                if (cVar.getBizType() == type) {
                    return cVar;
                }
            }
        }
        return null;
    }

    private final synchronized void I() {
        if (this.mEggBizPlayers == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.mEggBizPlayers = copyOnWriteArrayList;
            Intrinsics.checkNotNull(copyOnWriteArrayList);
            copyOnWriteArrayList.add(new DragonKingEggsPlayer());
            List<com.tencent.mobileqq.aio.animation.egg.c> list = this.mEggBizPlayers;
            Intrinsics.checkNotNull(list);
            list.add(new com.tencent.mobileqq.aio.animation.business.e());
            List<com.tencent.mobileqq.aio.animation.egg.c> list2 = this.mEggBizPlayers;
            Intrinsics.checkNotNull(list2);
            list2.add(new com.tencent.mobileqq.aio.animation.business.m());
            List<com.tencent.mobileqq.aio.animation.egg.c> list3 = this.mEggBizPlayers;
            Intrinsics.checkNotNull(list3);
            list3.add(new com.tencent.mobileqq.aio.animation.business.p());
        }
    }

    private final void J(com.tencent.mobileqq.aio.animation.config.a rule) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id:" + rule.h() + ",type:" + rule.r() + ",");
        stringBuffer.append("keywords:[");
        ArrayList<com.tencent.mobileqq.aio.animation.egg.a> m3 = rule.m();
        if (m3 != null) {
            Iterator<T> it = m3.iterator();
            while (it.hasNext()) {
                stringBuffer.append("{keyword:" + ((com.tencent.mobileqq.aio.animation.egg.a) it.next()).a() + "},");
            }
        }
        stringBuffer.append("],");
        stringBuffer.append("images:[");
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = rule.i();
        if (i3 != null) {
            for (com.tencent.mobileqq.aio.animation.config.e eVar : i3) {
                stringBuffer.append("{type:" + eVar.h() + ",value:" + eVar.k() + "},");
            }
        }
        stringBuffer.append("]");
        QLog.i("AioAnimationDetector", 1, "rule:" + ((Object) stringBuffer));
    }

    private final void L(final BaseQQAppInterface app, final com.tencent.mobileqq.aio.animation.data.b message, final AIOAnimationContainer animContainer, int delayTimeBase, final com.tencent.mobileqq.aio.animation.config.a rule) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("AioAnimationDetector", 2, "[onC2CAnimationTriggered] ruleId=" + rule.h() + " msgId=" + message.getMsgId());
        }
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = rule.i();
        if (i3 != null && !i3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("AioAnimationDetector", 1, "[onC2CAnimationTriggered] jump image is empty, ruleId=" + rule.h());
            return;
        }
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i16 = rule.i();
        Intrinsics.checkNotNull(i16);
        com.tencent.mobileqq.aio.animation.config.e eVar = i16.get(0);
        Intrinsics.checkNotNullExpressionValue(eVar, "rule.jumpImageList!![0]");
        e.Companion companion = com.tencent.mobileqq.aio.animation.config.e.INSTANCE;
        MobileQQ application = app.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "app.application");
        final Drawable c16 = companion.c(application, eVar);
        this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.n
            @Override // java.lang.Runnable
            public final void run() {
                q.M(q.this, app, animContainer, c16, rule, message);
            }
        }, delayTimeBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(q this$0, BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.V(app, animContainer, drawable, 0, rule, message);
    }

    private final void N(final BaseQQAppInterface app, final com.tencent.mobileqq.aio.animation.data.b message, final AIOAnimationContainer animContainer, int delayTimeBase, final com.tencent.mobileqq.aio.animation.config.a rule) {
        if (QLog.isColorLevel()) {
            QLog.i("AioAnimationDetector", 1, "[onC2CCrazyModeTriggered] msgId=" + message.getMsgId());
        }
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = rule.i();
        if (i3 != null) {
            int i16 = 0;
            for (com.tencent.mobileqq.aio.animation.config.e eVar : i3) {
                e.Companion companion = com.tencent.mobileqq.aio.animation.config.e.INSTANCE;
                MobileQQ application = app.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "app.application");
                final Drawable c16 = companion.c(application, eVar);
                int i17 = i16 + 1;
                final int i18 = i16 * 800;
                this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.O(q.this, app, animContainer, c16, i18, rule, message);
                    }
                }, delayTimeBase + i18);
                i16 = i17;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(q this$0, BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, int i3, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.V(app, animContainer, drawable, i3, rule, message);
    }

    private final void P(BaseQQAppInterface app, com.tencent.mobileqq.aio.animation.data.b message, AIOAnimationContainer animContainer, int delayTimeBase, com.tencent.mobileqq.aio.animation.config.a rule, boolean isNewMsg, ArrayList<com.tencent.mobileqq.aio.animation.config.a> rulesMatched, int index) {
        if (QLog.isColorLevel()) {
            QLog.i("AioAnimationDetector", 1, "[onGroupAnimationTriggered] msgId=" + message.getMsgId());
        }
        if (y(app, message, 2, animContainer, delayTimeBase, rule, isNewMsg, rulesMatched, index)) {
            return;
        }
        W(rule, app, animContainer, message, delayTimeBase);
    }

    private final void Q(BaseQQAppInterface app, com.tencent.mobileqq.aio.animation.config.a rule) {
        if (!this.mHasWebToolsStart.get()) {
            if (com.tencent.mobileqq.aio.animation.util.e.f188167a.b(rule)) {
                ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class)).preLoadBrowser(app);
            }
            this.mHasWebToolsStart.set(true);
        }
    }

    private final void R(List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList, com.tencent.mobileqq.aio.animation.data.d session, BaseQQAppInterface app, AIOAnimationContainer animContainer) {
        if (msgList.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AioAnimationDetector", 4, "[realHandleMsg] msg list is empty, return");
                return;
            }
            return;
        }
        for (com.tencent.mobileqq.aio.animation.data.b bVar : msgList) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AioAnimationDetector", 4, "[realHandleMsg] match msg with seq " + bVar.getMsgSeq());
            }
            A(bVar, app, session);
            ArrayList<com.tencent.mobileqq.aio.animation.config.a> B = B(session, K(bVar));
            if (B != null) {
                T(app, B, session.c(), bVar, true, animContainer, 0, true);
            }
        }
    }

    private final void S(boolean isC2C, com.tencent.mobileqq.aio.animation.data.b message, com.tencent.mobileqq.aio.animation.config.a rule) {
        com.tencent.mobileqq.aio.animation.util.e.f188167a.c(isC2C, message, rule);
    }

    private final void T(BaseQQAppInterface app, ArrayList<com.tencent.mobileqq.aio.animation.config.a> rulesMatched, boolean troopOrDiscussion, com.tencent.mobileqq.aio.animation.data.b message, boolean checkCombo, AIOAnimationContainer animContainer, int delayTimeBase, boolean isNewMsg) {
        com.tencent.mobileqq.aio.animation.data.b bVar = message;
        if (rulesMatched.isEmpty()) {
            return;
        }
        com.tencent.mobileqq.aio.animation.proto.a.f188147a.c(app, troopOrDiscussion, bVar, rulesMatched);
        Iterator it = rulesMatched.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.aio.animation.config.a aVar = (com.tencent.mobileqq.aio.animation.config.a) next;
            S(!troopOrDiscussion, bVar, aVar);
            int c16 = message.c();
            int f16 = aVar.f();
            int j3 = aVar.j();
            Iterator it5 = it;
            QLog.i("AioAnimationDetector", 1, "[detect] ruleId:" + aVar.h() + " ruleType:" + aVar.r() + " keyword:" + com.tencent.util.k.d(aVar.o()) + " troopOrDiscussion:" + troopOrDiscussion + " msgId:" + message.getMsgId() + " msgSeq:" + message.getMsgSeq() + " M=" + c16 + ",X=" + f16 + ",Y=" + j3 + ",crazyMode=" + aVar.c());
            if (!troopOrDiscussion) {
                if (f16 == 0 && j3 == 0 && !y(app, message, 1, animContainer, delayTimeBase, aVar, isNewMsg, rulesMatched, i3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AioAnimationDetector", 2, "detect c2c =======>  egg_jumper animation, crazyModeEnable=" + aVar.c());
                    }
                    if (aVar.c()) {
                        N(app, message, animContainer, delayTimeBase, aVar);
                    } else {
                        L(app, message, animContainer, delayTimeBase, aVar);
                    }
                }
            } else if (f16 == 0 && j3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "detect =======>  egg_jumper animation, crazyModeEnable=" + aVar.c());
                }
                P(app, message, animContainer, delayTimeBase, aVar, isNewMsg, rulesMatched, i3);
            } else {
                o(app, f16, c16, j3, message, animContainer, delayTimeBase, aVar, checkCombo);
            }
            bVar = message;
            it = it5;
            i3 = i16;
        }
    }

    private final void V(BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable d16, int delay, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        if (d16 == null) {
            QLog.i("AioAnimationDetector", 1, "[startJumpEggsAnimation] drawable is null, msg=" + message.e());
            J(rule);
            return;
        }
        animContainer.m(2, 300, d16, Integer.valueOf(delay), Integer.valueOf(rule.a()), rule, message);
        Q(app, rule);
    }

    private final void W(final com.tencent.mobileqq.aio.animation.config.a rule, final BaseQQAppInterface app, final AIOAnimationContainer animContainer, final com.tencent.mobileqq.aio.animation.data.b message, int delayTimeBase) {
        if (QLog.isColorLevel()) {
            QLog.i("AioAnimationDetector", 1, "[startJumperAnimation] msgId=" + message.getMsgId());
        }
        if (rule.c()) {
            ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = rule.i();
            Intrinsics.checkNotNull(i3);
            int size = i3.size();
            for (int i16 = 0; i16 < size; i16++) {
                ArrayList<com.tencent.mobileqq.aio.animation.config.e> i17 = rule.i();
                Intrinsics.checkNotNull(i17);
                com.tencent.mobileqq.aio.animation.config.e eVar = i17.get(i16);
                Intrinsics.checkNotNullExpressionValue(eVar, "rule.jumpImageList!!.get(i)");
                e.Companion companion = com.tencent.mobileqq.aio.animation.config.e.INSTANCE;
                MobileQQ application = app.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "app.getApplication()");
                final Drawable c16 = companion.c(application, eVar);
                final int i18 = i16 * 800;
                this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.X(q.this, app, animContainer, c16, i18, rule, message);
                    }
                }, delayTimeBase + i18);
            }
            return;
        }
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i19 = rule.i();
        Intrinsics.checkNotNull(i19);
        com.tencent.mobileqq.aio.animation.config.e eVar2 = i19.get(0);
        Intrinsics.checkNotNullExpressionValue(eVar2, "rule.jumpImageList!!.get(0)");
        e.Companion companion2 = com.tencent.mobileqq.aio.animation.config.e.INSTANCE;
        MobileQQ application2 = app.getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "app.getApplication()");
        final Drawable c17 = companion2.c(application2, eVar2);
        this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.p
            @Override // java.lang.Runnable
            public final void run() {
                q.Y(q.this, app, animContainer, c17, rule, message);
            }
        }, delayTimeBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(q this$0, BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, int i3, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.V(app, animContainer, drawable, i3, rule, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(q this$0, BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.V(app, animContainer, drawable, 0, rule, message);
    }

    private final void Z(List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList, long lastParsedMsgSeq, IAIOAnimationMsgManager msgManger, com.tencent.mobileqq.aio.animation.data.d session) {
        long E = E(msgList);
        if (E > lastParsedMsgSeq) {
            msgManger.updateParsedMsgSeq(session.b(), E);
        }
    }

    private final boolean m() {
        if (QLog.isDevelopLevel()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastPrintLogTime > 1000) {
            this.lastPrintLogTime = currentTimeMillis;
            return true;
        }
        return false;
    }

    private final void o(final BaseQQAppInterface app, int X, final int M, int Y, final com.tencent.mobileqq.aio.animation.data.b message, final AIOAnimationContainer animContainer, int delayTimeBase, final com.tencent.mobileqq.aio.animation.config.a rule, boolean checkCombo) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (X >= Y || M < X) {
            return;
        }
        String str = "app.application";
        int i19 = 1;
        if (M != Y) {
            String str2 = "app.application";
            if (M > Y) {
                if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "detect (M > Y) =======>  egg_combo animation, checkCombo=" + checkCombo + ", Y=" + Y + ",crazyModeEnable=" + rule.c());
                }
                if (checkCombo) {
                    this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            q.r(AIOAnimationContainer.this, M, message);
                        }
                    }, delayTimeBase);
                }
                if (checkCombo) {
                    i3 = 1000;
                } else {
                    i3 = 0;
                }
                if (rule.c()) {
                    ArrayList<com.tencent.mobileqq.aio.animation.config.e> i26 = rule.i();
                    Intrinsics.checkNotNull(i26);
                    i19 = i26.size();
                }
                int i27 = i19;
                int i28 = 0;
                while (i28 < i27) {
                    ArrayList<com.tencent.mobileqq.aio.animation.config.e> i29 = rule.i();
                    Intrinsics.checkNotNull(i29);
                    com.tencent.mobileqq.aio.animation.config.e eVar = i29.get(i28);
                    Intrinsics.checkNotNullExpressionValue(eVar, "rule.jumpImageList!![i]");
                    e.Companion companion = com.tencent.mobileqq.aio.animation.config.e.INSTANCE;
                    MobileQQ application = app.getApplication();
                    String str3 = str2;
                    Intrinsics.checkNotNullExpressionValue(application, str3);
                    final Drawable c16 = companion.c(application, eVar);
                    if (rule.r() == 8) {
                        i16 = i27;
                        this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                q.s(q.this, app, animContainer, c16, rule, message);
                            }
                        });
                        str2 = str3;
                    } else {
                        i16 = i27;
                        final int i36 = i28 * 800;
                        str2 = str3;
                        this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                q.t(q.this, app, animContainer, c16, i36, rule, message);
                            }
                        }, delayTimeBase + i3 + i36);
                    }
                    i28++;
                    i27 = i16;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AioAnimationDetector", 2, "detect (X <= M < Y) ======>  egg_combo animation, checkCombo= " + checkCombo);
            }
            if (!checkCombo) {
                return;
            }
            this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.m
                @Override // java.lang.Runnable
                public final void run() {
                    q.u(AIOAnimationContainer.this, M, message);
                }
            }, delayTimeBase);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_combo animation, checkCombo= " + checkCombo);
        }
        if (checkCombo) {
            this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.h
                @Override // java.lang.Runnable
                public final void run() {
                    q.p(AIOAnimationContainer.this, M, message);
                }
            }, delayTimeBase + 0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "detect (M == Y) =======>  egg_jumper animation ,Y=" + Y + ",crazyModeEnable=" + rule.c());
        }
        int i37 = 0;
        while (i37 < Y) {
            if (checkCombo) {
                i17 = 1000;
            } else {
                i17 = 0;
            }
            if (rule.c()) {
                ArrayList<com.tencent.mobileqq.aio.animation.config.e> i38 = rule.i();
                Intrinsics.checkNotNull(i38);
                i18 = i38.size();
            } else {
                i18 = 1;
            }
            int i39 = 0;
            while (i39 < i18) {
                ArrayList<com.tencent.mobileqq.aio.animation.config.e> i46 = rule.i();
                Intrinsics.checkNotNull(i46);
                com.tencent.mobileqq.aio.animation.config.e eVar2 = i46.get(i39);
                Intrinsics.checkNotNullExpressionValue(eVar2, "rule.jumpImageList!!.get(i)");
                e.Companion companion2 = com.tencent.mobileqq.aio.animation.config.e.INSTANCE;
                MobileQQ application2 = app.getApplication();
                Intrinsics.checkNotNullExpressionValue(application2, str);
                final Drawable c17 = companion2.c(application2, eVar2);
                final int i47 = (i39 + i37) * 800;
                this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.q(q.this, app, animContainer, c17, i47, rule, message);
                    }
                }, delayTimeBase + i17 + i47);
                i39++;
                str = str;
                i18 = i18;
                i37 = i37;
            }
            i37++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AIOAnimationContainer animContainer, int i3, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(message, "$message");
        animContainer.m(1, 200, Integer.valueOf(i3), Long.valueOf(message.getMsgId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(q this$0, BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, int i3, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.V(app, animContainer, drawable, i3, rule, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AIOAnimationContainer animContainer, int i3, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(message, "$message");
        animContainer.m(1, 200, Integer.valueOf(i3), Long.valueOf(message.getMsgId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(q this$0, BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.U(app, animContainer, drawable, rule, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(q this$0, BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, int i3, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.V(app, animContainer, drawable, i3, rule, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AIOAnimationContainer animContainer, int i3, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(message, "$message");
        animContainer.m(1, 200, Integer.valueOf(i3), Long.valueOf(message.getMsgId()));
    }

    private final boolean v(com.tencent.mobileqq.aio.animation.config.a rule) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        com.tencent.mobileqq.aio.animation.config.b n3 = rule.n();
        if (n3 != null && n3.b() != 0 && n3.a() != 0) {
            if (n3.b() > currentTimeMillis || n3.a() < currentTimeMillis) {
                if (QLog.isColorLevel()) {
                    QLog.d("AioAnimationDetector", 2, "JD red pack, But not in date.");
                    return false;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private final synchronized void x() {
        List<com.tencent.mobileqq.aio.animation.egg.c> list = this.mEggBizPlayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            list.clear();
            this.mEggBizPlayers = null;
        }
    }

    private final boolean y(BaseQQAppInterface app, com.tencent.mobileqq.aio.animation.data.b message, int sessionType, AIOAnimationContainer animContainer, int delayTime, com.tencent.mobileqq.aio.animation.config.a rule, boolean isNewMsg, ArrayList<com.tencent.mobileqq.aio.animation.config.a> rulesMatched, int index) {
        I();
        if (rule.r() == -1) {
            QLog.i("AioAnimationDetector", 1, "[dispatchAnimationPlayEvent] unknown type");
            return false;
        }
        if (!rule.s()) {
            QLog.i("AioAnimationDetector", 1, "[dispatchAnimationPlayEvent] time not matched, ruleId=" + rule.h() + ", now=" + System.currentTimeMillis() + " validTime=" + rule.q() + "-" + rule.e());
            return true;
        }
        com.tencent.mobileqq.aio.animation.egg.c G = G(rule.r());
        if (G == null || (G.c() & sessionType) == 0) {
            return false;
        }
        G.a(app, this.uiHandler, message, animContainer, delayTime, rule, isNewMsg, rulesMatched, index);
        QLog.i("AioAnimationDetector", 1, "[dispatchAnimationPlayEvent] play animation,type=" + G.getBizType() + " ruleId=" + rule.h() + " session=" + sessionType);
        return true;
    }

    private final synchronized void z() {
        List<com.tencent.mobileqq.aio.animation.egg.c> list = this.mEggBizPlayers;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.aio.animation.egg.c) it.next()).onDestroy();
            }
        }
    }

    public final void H(@NotNull BaseQQAppInterface app, @NotNull List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList, @NotNull com.tencent.mobileqq.aio.animation.data.d session, @NotNull AIOAnimationContainer animContainer, boolean forceUpdateMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, msgList, session, animContainer, Boolean.valueOf(forceUpdateMsgSeq));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(animContainer, "animContainer");
        if (msgList.isEmpty()) {
            return;
        }
        List<com.tencent.mobileqq.aio.animation.data.b> F = F(app, msgList, session);
        if (forceUpdateMsgSeq) {
            C(session, msgList);
        }
        if (F.isEmpty()) {
            return;
        }
        R(F, session, app, animContainer);
    }

    @Nullable
    public final ArrayList<com.tencent.mobileqq.aio.animation.config.a> K(@Nullable com.tencent.mobileqq.aio.animation.data.b message) {
        ArrayList<com.tencent.mobileqq.aio.animation.config.a> arrayList;
        Iterator<com.tencent.mobileqq.aio.animation.config.a> it;
        q qVar = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) qVar, (Object) message);
        }
        if (message == null || Intrinsics.areEqual(message.getPeerUid(), MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid())) {
            return null;
        }
        List<com.tencent.mobileqq.aio.animation.config.a> e16 = AioAnimationConfigHolder.f188156a.e();
        if (e16 == null) {
            QLog.d("AioAnimationDetector", 2, "match : rules == null, just return;");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String e17 = message.e();
            if (TextUtils.isEmpty(e17)) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 500) {
                    QLog.w("AioAnimationDetector", 1, "match duration: " + currentTimeMillis2 + " ms");
                }
                return null;
            }
            int a16 = message.a();
            int chatType = message.getChatType();
            ArrayList<com.tencent.mobileqq.aio.animation.config.a> arrayList2 = new ArrayList<>();
            Iterator<com.tencent.mobileqq.aio.animation.config.a> it5 = e16.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.aio.animation.config.a next = it5.next();
                if (next.N(chatType)) {
                    ArrayList<com.tencent.mobileqq.aio.animation.egg.a> m3 = next.m();
                    if (m3 != null) {
                        int i3 = 0;
                        for (Object obj : m3) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            ArrayList<com.tencent.mobileqq.aio.animation.egg.a> m16 = next.m();
                            Intrinsics.checkNotNull(m16);
                            com.tencent.mobileqq.aio.animation.egg.a aVar = m16.get(i3);
                            Intrinsics.checkNotNullExpressionValue(aVar, "rule.keywordsList!![keyIndex]");
                            if (aVar.c(e17, a16) && qVar.v(next)) {
                                it = it5;
                                if (!qVar.interceptPart.a(next.h(), message.getSenderUin(), message.getVipType())) {
                                    com.tencent.mobileqq.aio.animation.config.a aVar2 = new com.tencent.mobileqq.aio.animation.config.a(next);
                                    aVar2.H(i3);
                                    arrayList2.add(aVar2);
                                }
                                qVar = this;
                                it5 = it;
                                i3 = i16;
                            }
                            it = it5;
                            qVar = this;
                            it5 = it;
                            i3 = i16;
                        }
                        qVar = this;
                    } else {
                        qVar = this;
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = arrayList2;
            }
            return arrayList;
        } finally {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis3 > 500) {
                QLog.w("AioAnimationDetector", 1, "match duration: " + currentTimeMillis3 + " ms");
            }
        }
    }

    public final void U(@NotNull BaseQQAppInterface app, @NotNull AIOAnimationContainer animContainer, @Nullable Drawable d16, @NotNull com.tencent.mobileqq.aio.animation.config.a rule, @NotNull com.tencent.mobileqq.aio.animation.data.b message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, app, animContainer, d16, rule, message);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(animContainer, "animContainer");
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(message, "message");
        animContainer.f(8, 300, d16, rule, message);
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AioAnimationDetector", 2, "[cancelAll]");
        }
        this.uiHandler.removeCallbacksAndMessages(null);
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AioAnimationDetector", 1, "[destroy]");
        }
        this.uiHandler.removeCallbacksAndMessages(null);
        x();
        z();
    }

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasWebToolsStart = new AtomicBoolean(false);
        this.interceptPart = new v71.a();
        this.uiHandler = new Handler(Looper.getMainLooper());
        I();
    }
}
