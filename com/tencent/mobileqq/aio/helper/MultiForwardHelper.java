package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.help.b;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IMultiSelectApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0012*\u0001L\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0010H\u0002J<\u0010\u0018\u001a\u00020\u00052\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0014H\u0002J<\u0010\u0019\u001a\u00020\u00052\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0018\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0012j\b\u0012\u0004\u0012\u00020\u001c`\u0014H\u0002J\u0018\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0012j\b\u0012\u0004\u0012\u00020\u001e`\u0014H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010%\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0#H\u0002J\b\u0010&\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020'H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020'H\u0016J\b\u00109\u001a\u00020\rH\u0016R\u0016\u0010<\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010ER\u0016\u0010H\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010MR\u001b\u0010R\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010O\u001a\u0004\bP\u0010QR\u001b\u0010T\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010O\u001a\u0004\bS\u0010QR\u001b\u0010X\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010O\u001a\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/MultiForwardHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/aio/api/help/b;", "Lcom/tencent/mvi/base/route/g;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "r", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", ReportConstant.COSTREPORT_PREFIX, "E", "Lcom/tencent/mobileqq/aio/event/MsgForwardEvent$MultiForwardSelectResult;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lkotlin/collections/ArrayList;", "dstContacts", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "comments", "o", DomainData.DOMAIN_NAME, "selectMode", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/MultiMsgInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "p", "w", "k", "u", "", "msgItemList", "D", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", tl.h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "state", "onMoveToState", "onBackEvent", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "f", "Z", "mSelectMode", "", "Ljava/util/List;", "mSelectMsgList", "I", "mForwardType", "Landroid/os/Handler;", "Landroid/os/Handler;", "mUiHandler", "com/tencent/mobileqq/aio/helper/MultiForwardHelper$b", "Lcom/tencent/mobileqq/aio/helper/MultiForwardHelper$b;", "mAction", "Lkotlin/Lazy;", "getMPeerId", "()Ljava/lang/String;", "mPeerId", "getMNick", "mNick", UserInfo.SEX_FEMALE, "getMChatType", "()I", "mChatType", "<init>", "()V", "G", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class MultiForwardHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.runtime.emitter.a, com.tencent.aio.api.help.b, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int H;
    private static final int I;
    private static final int J;
    private static final int K;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPeerId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mNick;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mChatType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mSelectMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AIOMsgItem> mSelectMsgList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mForwardType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mUiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/MultiForwardHelper$a;", "", "", "EM_BAS_CHAT_HISTORY_SHARING_POPUP", "Ljava/lang/String;", "", "ITEM_CANCLE", "I", "ITEM_FORWARD_SEPARATE", "ITEM_FORWARD_TOGETHER", "ITEM_IMAGE_SHARE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.MultiForwardHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/MultiForwardHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiForwardHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                MultiForwardHelper.this.r(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        H = 1;
        I = 2;
        J = 3;
        K = 4;
    }

    public MultiForwardHelper() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSelectMsgList = new ArrayList();
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mAction = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.aio.helper.MultiForwardHelper$mPeerId$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiForwardHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                com.tencent.aio.main.businesshelper.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bVar = MultiForwardHelper.this.mHelperParam;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    bVar = null;
                }
                return bVar.a().g().r().c().j();
            }
        });
        this.mPeerId = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.aio.helper.MultiForwardHelper$mNick$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiForwardHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                com.tencent.aio.main.businesshelper.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bVar = MultiForwardHelper.this.mHelperParam;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    bVar = null;
                }
                return bVar.a().g().r().c().g();
            }
        });
        this.mNick = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.aio.helper.MultiForwardHelper$mChatType$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiForwardHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                com.tencent.aio.main.businesshelper.b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bVar = MultiForwardHelper.this.mHelperParam;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                    bVar = null;
                }
                return Integer.valueOf(bVar.a().g().r().c().e());
            }
        });
        this.mChatType = lazy3;
    }

    private final void A(int item) {
        int size = this.mSelectMsgList.size();
        HashMap hashMap = new HashMap();
        hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, Integer.valueOf(item));
        hashMap.put("messages_number", Integer.valueOf(size));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_chat_history_sharing_popup", hashMap);
    }

    private final void B(int item) {
        HashMap hashMap = new HashMap();
        hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, Integer.valueOf(item));
        com.tencent.mobileqq.aio.utils.b.q("em_bas_chat_history_sharing_popup", hashMap);
    }

    private final void C(boolean selectMode) {
        this.mSelectMode = selectMode;
        this.mSelectMsgList.clear();
    }

    private final void D(List<? extends AIOMsgItem> msgItemList) {
        this.mSelectMsgList.clear();
        this.mSelectMsgList.addAll(msgItemList);
    }

    private final void E() {
        if (this.mContext != null && !this.mSelectMsgList.isEmpty()) {
            List<AIOMsgItem> list = this.mSelectMsgList;
            final ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!w((AIOMsgItem) obj)) {
                    arrayList.add(obj);
                }
            }
            final Context context = this.mContext;
            if (context != null) {
                final ActionSheet create = ActionSheet.create(context);
                if (v()) {
                    create.addButton(R.string.f169522ik);
                    B(J);
                }
                create.addButton(R.string.ceh);
                create.addButton(R.string.cei);
                create.addCancelButton(R.string.cancel);
                B(H);
                B(I);
                B(K);
                create.setOnButtonClickListenerV2(new ActionSheet.OnButtonClickListenerV2() { // from class: com.tencent.mobileqq.aio.helper.ar
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
                    public final void OnClick(View view, int i3, String str) {
                        MultiForwardHelper.F(MultiForwardHelper.this, arrayList, create, context, view, i3, str);
                    }
                });
                create.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.helper.as
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MultiForwardHelper.G(MultiForwardHelper.this, create, view);
                    }
                });
                create.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public static final void F(MultiForwardHelper this$0, List msgList, ActionSheet actionSheet, Context it, View view, int i3, String str) {
        String str2;
        String str3;
        String str4;
        Resources resources;
        Resources resources2;
        Resources resources3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        Intrinsics.checkNotNullParameter(it, "$it");
        Context context = this$0.mContext;
        com.tencent.aio.main.businesshelper.b bVar = null;
        byte b16 = 0;
        if (context != null && (resources3 = context.getResources()) != null) {
            str2 = resources3.getString(R.string.f169522ik);
        } else {
            str2 = null;
        }
        int i16 = 0;
        i16 = 0;
        if (str.equals(str2)) {
            com.tencent.aio.main.businesshelper.b bVar2 = this$0.mHelperParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                bVar2 = null;
            }
            bVar2.a().e().h(new CreateHelperIntent.CreateHelperRealIntent(3, new LongShotMsgIntent.CompleteShotAndShare(msgList, i16, 2, b16 == true ? 1 : 0), null, 4, null));
            actionSheet.dismiss();
            this$0.A(J);
            return;
        }
        Context context2 = this$0.mContext;
        if (context2 != null && (resources2 = context2.getResources()) != null) {
            str3 = resources2.getString(R.string.ceh);
        } else {
            str3 = null;
        }
        if (Intrinsics.areEqual(str, str3)) {
            this$0.A(H);
            i16 = 1;
        } else {
            Context context3 = this$0.mContext;
            if (context3 != null && (resources = context3.getResources()) != null) {
                str4 = resources.getString(R.string.cei);
            } else {
                str4 = null;
            }
            if (Intrinsics.areEqual(str, str4)) {
                this$0.A(I);
            }
        }
        this$0.mForwardType = i16;
        IMultiSelectApi iMultiSelectApi = (IMultiSelectApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiSelectApi.class);
        int i17 = this$0.mForwardType;
        com.tencent.aio.main.businesshelper.b bVar3 = this$0.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar3 = null;
        }
        AIOContact c16 = bVar3.a().g().r().c();
        com.tencent.aio.main.businesshelper.b bVar4 = this$0.mHelperParam;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar = bVar4;
        }
        com.tencent.mvi.base.route.j e16 = bVar.a().e();
        Intrinsics.checkNotNullExpressionValue(e16, "mHelperParam.aioContext.messenger");
        iMultiSelectApi.multiForwardSelect(it, i17, c16, msgList, e16);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MultiForwardHelper this$0, ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A(K);
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H() {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.mAction);
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    private final void k() {
        if (!this.mSelectMode) {
            return;
        }
        C(false);
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().h(new AIOMsgListEvent.MultiSelectModeChangeEvent("MultiForwardHelper", false));
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().e().h(new AIOMsgListEvent.SetCommunicationShareButton(false));
    }

    private final void m(MsgForwardEvent.MultiForwardSelectResult intent) {
        boolean z16 = true;
        QLog.d("MultiForwardHelper", 1, "forward selectMode=" + this.mSelectMode + " intent=" + intent);
        if (!this.mSelectMode) {
            return;
        }
        if (!intent.d()) {
            if (intent.c()) {
                k();
                return;
            }
            return;
        }
        ArrayList<Contact> b16 = intent.b();
        if (b16 == null) {
            return;
        }
        String a16 = intent.a();
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        }
        ArrayList<MsgElement> arrayList = null;
        if (!z16) {
            AIOObjectTransform aIOObjectTransform = AIOObjectTransform.f194080a;
            com.tencent.mobileqq.aio.utils.y yVar = com.tencent.mobileqq.aio.utils.y.f194180a;
            String a17 = intent.a();
            Intrinsics.checkNotNull(a17);
            arrayList = AIOObjectTransform.m(aIOObjectTransform, com.tencent.mobileqq.aio.utils.y.d(yVar, a17, 0, 0L, 0L, null, 30, null), 0, 2, null);
        }
        if (this.mForwardType == 0) {
            o(b16, arrayList);
        } else {
            n(b16, arrayList);
        }
        k();
    }

    private final void n(ArrayList<Contact> dstContacts, ArrayList<MsgElement> comments) {
        ArrayList<Long> p16 = p();
        if (p16.isEmpty()) {
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        AIOMsgService.f190196a.g(new com.tencent.mobileqq.aio.msg.service.s(bVar.a().g().r(), p16, dstContacts, comments));
        k();
    }

    private final void o(ArrayList<Contact> dstContacts, ArrayList<MsgElement> comments) {
        ArrayList<MultiMsgInfo> q16 = q();
        if (q16.isEmpty()) {
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        AIOSession r16 = bVar.a().g().r();
        Iterator<T> it = dstContacts.iterator();
        while (it.hasNext()) {
            AIOMsgService.f190196a.m(new com.tencent.mobileqq.aio.msg.service.u(r16, q16, (Contact) it.next(), comments));
        }
        k();
    }

    private final ArrayList<Long> p() {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (AIOMsgItem aIOMsgItem : this.mSelectMsgList) {
            if (!w(aIOMsgItem) && com.tencent.mobileqq.aio.utils.d.U(aIOMsgItem)) {
                arrayList.add(Long.valueOf(aIOMsgItem.getMsgId()));
            }
        }
        return arrayList;
    }

    private final ArrayList<MultiMsgInfo> q() {
        ArrayList<MultiMsgInfo> arrayList = new ArrayList<>();
        for (AIOMsgItem aIOMsgItem : this.mSelectMsgList) {
            if (!w(aIOMsgItem) && com.tencent.mobileqq.aio.utils.d.U(aIOMsgItem)) {
                arrayList.add(new MultiMsgInfo(aIOMsgItem.getMsgId(), aIOMsgItem.getMsgRecord().sendNickName));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final MsgIntent intent) {
        if (intent instanceof MultiSelectEvent.UpdateCommunicationShareCount) {
            t();
            return;
        }
        if (intent instanceof MultiSelectEvent.MultiForwardShowEvent) {
            E();
            return;
        }
        if (intent instanceof MultiSelectEvent.AddSelectMsg) {
            MultiSelectEvent.AddSelectMsg addSelectMsg = (MultiSelectEvent.AddSelectMsg) intent;
            addSelectMsg.b(s(addSelectMsg.a()));
            return;
        }
        if (intent instanceof MultiSelectEvent.SetSelectMsgList) {
            D(((MultiSelectEvent.SetSelectMsgList) intent).a());
            return;
        }
        if (intent instanceof MultiSelectEvent.RemoveSelectMsg) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.mSelectMsgList, (Function1) new Function1<AIOMsgItem, Boolean>() { // from class: com.tencent.mobileqq.aio.helper.MultiForwardHelper$handleAction$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgIntent.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull AIOMsgItem it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getMsgId() == ((MultiSelectEvent.RemoveSelectMsg) MsgIntent.this).a().getMsgId());
                }
            });
            return;
        }
        if (intent instanceof MultiSelectEvent.GetSelectMode) {
            ((MultiSelectEvent.GetSelectMode) intent).b(this.mSelectMode);
            return;
        }
        if (intent instanceof MultiSelectEvent.IsMsgSelect) {
            MultiSelectEvent.IsMsgSelect isMsgSelect = (MultiSelectEvent.IsMsgSelect) intent;
            isMsgSelect.c(u(isMsgSelect.a()));
            return;
        }
        if (intent instanceof MultiSelectEvent.GetSelectMsgSum) {
            ((MultiSelectEvent.GetSelectMsgSum) intent).b(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.c(this.mSelectMsgList));
            return;
        }
        if (intent instanceof MultiSelectEvent.GetSelectNormalMsgSum) {
            ((MultiSelectEvent.GetSelectNormalMsgSum) intent).b(com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.d(this.mSelectMsgList));
            return;
        }
        if (intent instanceof MultiSelectEvent.SetSelectMode) {
            C(((MultiSelectEvent.SetSelectMode) intent).a());
            return;
        }
        if (intent instanceof MultiSelectEvent.GetSelectMsgList) {
            ((MultiSelectEvent.GetSelectMsgList) intent).b(this.mSelectMsgList);
        } else if (intent instanceof MsgForwardEvent.MultiForwardSelectResult) {
            m((MsgForwardEvent.MultiForwardSelectResult) intent);
        } else if (intent instanceof MsgForwardEvent.ExitMultiForward) {
            k();
        }
    }

    private final boolean s(AIOMsgItem msgItem) {
        List<AIOMsgItem> list = this.mSelectMsgList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((AIOMsgItem) next).getMsgId() != msgItem.getMsgId()) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            return false;
        }
        if (com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.c(this.mSelectMsgList) + msgItem.S() > 100) {
            String string = BaseApplication.context.getString(R.string.f6w, 100);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ChildVM.MSG_SELECT_LIMIT)");
            QQToast.makeText(BaseApplication.context, string, 0).show();
            return false;
        }
        this.mSelectMsgList.add(msgItem);
        return true;
    }

    private final void t() {
        if (this.mSelectMsgList.isEmpty()) {
            return;
        }
        List<AIOMsgItem> list = this.mSelectMsgList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!com.tencent.mobileqq.aio.utils.d.s((AIOMsgItem) obj)) {
                arrayList.add(obj);
            }
        }
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().h(new CreateHelperIntent.CreateHelperRealIntent(3, new LongShotMsgIntent.CompleteShotAndShare(arrayList, false, 2, defaultConstructorMarker), null, 4, null));
    }

    private final boolean u(AIOMsgItem msgItem) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.mSelectMsgList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((AIOMsgItem) obj).getMsgId() == msgItem.getMsgId()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final boolean v() {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "mHelperParam.aioContext.aioParam");
        long a16 = su3.c.a(g16);
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar3;
        }
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(a16), Integer.valueOf(bVar2.a().g().r().c().e()));
    }

    private final boolean w(AIOMsgItem msgItem) {
        if (!(msgItem instanceof MarkdownMsgItem) || !com.tencent.mobileqq.aio.utils.d.R(msgItem)) {
            return false;
        }
        return !((MarkdownMsgItem) msgItem).P2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MultiForwardHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MultiForwardHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
    }

    private final void z() {
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().e().f(this, this.mAction);
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.MultiForwardShowEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.AddSelectMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.RemoveSelectMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.SetSelectMsgList");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.SetSelectMode");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.GetSelectMode");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.IsMsgSelect");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.GetSelectMsgSum");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.GetSelectMsgList");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgForwardEvent.MultiForwardSelectResult");
        hashSet.add("com.tencent.mobileqq.aio.event.MsgForwardEvent.ExitMultiForward");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.GetSelectNormalMsgSum");
        hashSet.add("com.tencent.mobileqq.aio.event.MultiSelectEvent.UpdateCommunicationShareCount");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Set) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MultiForwardHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        b.a.a(this, param);
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.aq
            @Override // java.lang.Runnable
            public final void run() {
                MultiForwardHelper.x(MultiForwardHelper.this);
            }
        });
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            b.a.b(this);
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.ap
                @Override // java.lang.Runnable
                public final void run() {
                    MultiForwardHelper.y(MultiForwardHelper.this);
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.mSelectMode) {
            k();
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParam = param;
        Context context = null;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            param = null;
        }
        Fragment c16 = param.a().c();
        if (c16 != null) {
            context = c16.getContext();
        }
        this.mContext = context;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        h.a.b(this);
        C(false);
        this.mContext = null;
        this.mSelectMode = false;
        this.mSelectMsgList.clear();
        this.mForwardType = 0;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, state);
        }
    }
}
