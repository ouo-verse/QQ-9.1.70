package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.entity.MsgListPluginEntity;
import com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.handler.PublicAccountSettingHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIDoubleLineListItem;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pb.oac.OACProfilePb$ProfileDataRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.chats.biz.publicaccount.IPublicAccountChatsApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountProfile;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001}B\u0007\u00a2\u0006\u0004\b{\u0010|J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u0011H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fH\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0002JT\u00100\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020(2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u00102\u001a\u000201H\u0002JH\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-\"\b\b\u0000\u00105*\u000204\"\b\b\u0001\u00107*\u000206*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*H\u0002J\u0012\u0010;\u001a\u00020\u00022\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\u0012\u0010<\u001a\u00020\u001e2\b\u0010:\u001a\u0004\u0018\u000109H\u0002J\u0012\u0010?\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010=H\u0002J\u001a\u0010D\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J\b\u0010F\u001a\u0004\u0018\u00010EJ\u0018\u0010I\u001a\u00020\u00022\u0006\u0010G\u001a\u00020$2\b\b\u0002\u0010H\u001a\u00020\u001eJ\u000e\u0010K\u001a\u00020\u00022\u0006\u0010J\u001a\u00020&J\b\u0010L\u001a\u00020\u0002H\u0016J\b\u0010M\u001a\u00020\u0002H\u0016J\b\u0010N\u001a\u00020\u0002H\u0016J\u0013\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0O\u00a2\u0006\u0004\bP\u0010QJ\u0013\u0010R\u001a\b\u0012\u0004\u0012\u00020\b0O\u00a2\u0006\u0004\bR\u0010QJ\b\u0010S\u001a\u00020\u0002H\u0004J\u000e\u0010U\u001a\u00020$2\u0006\u0010T\u001a\u00020&R\u0018\u0010X\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\\R\u0016\u0010_\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010ZR\u0016\u0010G\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR0\u0010i\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020b\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010k\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020b\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010dR\u0014\u0010n\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010mR\u0016\u0010p\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010ZR\u0016\u0010t\u001a\u0004\u0018\u00010q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u001b\u0010z\u001a\u00020u8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\u00a8\u0006~"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "", "Hi", "Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDetailImpl;", "detail", "Gi", "Ji", "Lcom/tencent/mobileqq/widget/listitem/Group;", "di", "oi", "Fi", "ei", "Ei", "Bi", "Lcom/tencent/mobileqq/widget/listitem/a;", "Wh", "", "Uh", "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/c$a$d;", "Lcom/tencent/mobileqq/widget/listitem/c$b$c;", "Xh", "Lcom/tencent/mobileqq/widget/listitem/v;", "Yh", "Vh", "pi", "ki", "Ci", "zi", "", "isChecked", "mi", "isTop", "isTopAvailable", "Th", "", "leftText", "", "leftIcon", "", "rightText", "Lkotlin/Function0;", NodeProps.ON_CLICK, "onExpo", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "xi", "", "peerUin", "gi", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "ri", "Lcom/tencent/mobileqq/mp/mobileqq_mp$ButtonInfo;", "buttonInfo", SensorJsPlugin.SENSOR_INTERVAL_UI, "ti", "Lcom/tencent/biz/ui/c;", "menuItem", "ci", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/app/QQAppInterface;", "Sh", "uin", "updateUI", "ii", VasLiveIPCModule.KEY_FOLLOW_TYPE, "Ii", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "bi", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "ai", "showActionSheet", "resId", "ni", "J", "Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDetailImpl;", "accountDetail", "K", "Z", "showTopItem", "I", "reloadTime", "M", "mActionSheetClicked", "N", "Ljava/lang/String;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "P", "Lcom/tencent/mobileqq/widget/listitem/x;", "hi", "()Lcom/tencent/mobileqq/widget/listitem/x;", "setSetTopConfig", "(Lcom/tencent/mobileqq/widget/listitem/x;)V", "setTopConfig", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "businessSwitchConfig", "Lmqq/os/MqqHandler;", "Lmqq/os/MqqHandler;", "mQQUiHandler", ExifInterface.LATITUDE_SOUTH, "fromChatPage", "Lcom/tencent/biz/pubaccount/api/IPublicAccountDataManager;", "T", "Lcom/tencent/biz/pubaccount/api/IPublicAccountDataManager;", "pam", "Lcom/tencent/biz/pubaccount/accountdetail/model/i;", "U", "Lkotlin/Lazy;", "fi", "()Lcom/tencent/biz/pubaccount/accountdetail/model/i;", "accountDataCardViewModel", "<init>", "()V", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PublicAccountDataCardFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private PublicAccountDetailImpl accountDetail;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean showTopItem;

    /* renamed from: L, reason: from kotlin metadata */
    private int reloadTime;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mActionSheetClicked;

    /* renamed from: P, reason: from kotlin metadata */
    private x<x.b.d, x.c.f> setTopConfig;

    /* renamed from: Q, reason: from kotlin metadata */
    private x<x.b.d, x.c.f> businessSwitchConfig;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean fromChatPage;

    /* renamed from: T, reason: from kotlin metadata */
    private final IPublicAccountDataManager pam;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy accountDataCardViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    private String uin = "";

    /* renamed from: R, reason: from kotlin metadata */
    private final MqqHandler mQQUiHandler = new MqqHandler(Looper.getMainLooper());

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0017\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\u0006\u0010\u0010\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment$a;", "Lcom/tencent/mobileqq/widget/listitem/c$a;", "L", "Lcom/tencent/mobileqq/widget/listitem/c$b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/c;", "Lcom/tencent/mobileqq/widget/listitem/QUIDoubleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "l", "r", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/c$a;Lcom/tencent/mobileqq/widget/listitem/c$b;)V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a<L extends c.a, R extends c.b> extends com.tencent.mobileqq.widget.listitem.c<L, R> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(L l3, R r16) {
            super(l3, r16);
            Intrinsics.checkNotNullParameter(l3, "l");
            Intrinsics.checkNotNullParameter(r16, "r");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.c, com.tencent.mobileqq.widget.listitem.w
        /* renamed from: P */
        public void F(QUIDoubleLineListItem view, int position, List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            super.F(view, position, payloads);
            View findViewById = view.findViewById(R.id.f66193_z);
            ImageView imageView = findViewById instanceof ImageView ? (ImageView) findViewById : null;
            if (imageView != null) {
                ab.d(imageView, 0.0f);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment$b", "Lcom/tencent/biz/pubaccount/PublicAccountStQWebServletWrapper$b;", "Lcom/tencent/pb/oac/OACProfilePb$ProfileDataRsp;", "", "type", "", "succeeded", "data", "Landroid/os/Bundle;", "rawResponse", "", "c", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements PublicAccountStQWebServletWrapper.b<OACProfilePb$ProfileDataRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f79016b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f79017c;

        b(boolean z16, String str) {
            this.f79016b = z16;
            this.f79017c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(PublicAccountDataCardFragment this$0, String uin, OACProfilePb$ProfileDataRsp oACProfilePb$ProfileDataRsp) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(uin, "$uin");
            ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).savePublicAccountMenuSetting(this$0.Sh(), uin, oACProfilePb$ProfileDataRsp != null ? oACProfilePb$ProfileDataRsp.menu_rsp : null);
        }

        @Override // com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(int type, boolean succeeded, final OACProfilePb$ProfileDataRsp data, Bundle rawResponse) {
            if (succeeded) {
                PublicAccountDataCardFragment.this.accountDetail = new PublicAccountDetailImpl(data);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("load data onComplete is succeeded ");
                sb5.append(succeeded);
                sb5.append(", ");
                PublicAccountDetailImpl publicAccountDetailImpl = PublicAccountDataCardFragment.this.accountDetail;
                sb5.append(publicAccountDetailImpl != null ? Integer.valueOf(publicAccountDetailImpl.followType) : null);
                QLog.d(QPublicBaseFragment.TAG, 1, sb5.toString());
                final PublicAccountDataCardFragment publicAccountDataCardFragment = PublicAccountDataCardFragment.this;
                final String str = this.f79017c;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublicAccountDataCardFragment.b.d(PublicAccountDataCardFragment.this, str, data);
                    }
                }, 32, null, true);
                PublicAccountDataCardFragment publicAccountDataCardFragment2 = PublicAccountDataCardFragment.this;
                publicAccountDataCardFragment2.Gi(publicAccountDataCardFragment2.accountDetail);
                if (this.f79016b) {
                    PublicAccountDataCardFragment.this.Hi();
                    return;
                }
                return;
            }
            if (PublicAccountDataCardFragment.this.accountDetail == null) {
                PublicAccountDataCardFragment.this.accountDetail = new PublicAccountDetailImpl();
                QLog.d(QPublicBaseFragment.TAG, 1, "load data onComplete is failured ");
                if (this.f79016b) {
                    PublicAccountDataCardFragment.this.Hi();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment$d", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", QzoneIPCModule.RESULT_CODE, "", "isTop", "", "b", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d extends IPublicAccountCommonMrg.a {
        d() {
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void b(int resultCode, boolean isTop) {
            x<x.b.d, x.c.f> hi5 = PublicAccountDataCardFragment.this.hi();
            x.c.f O = hi5 != null ? hi5.O() : null;
            if (O == null) {
                return;
            }
            O.f(isTop);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment$e", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", QzoneIPCModule.RESULT_CODE, "", "isTop", "", "b", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e extends IPublicAccountCommonMrg.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(PublicAccountDataCardFragment this$0, boolean z16, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Th(z16, i3 == 0);
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void b(final int resultCode, final boolean isTop) {
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "onTopState resultCode:" + resultCode + " isTop:" + isTop);
            }
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final PublicAccountDataCardFragment publicAccountDataCardFragment = PublicAccountDataCardFragment.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.k
                @Override // java.lang.Runnable
                public final void run() {
                    PublicAccountDataCardFragment.e.e(PublicAccountDataCardFragment.this, isTop, resultCode);
                }
            });
        }
    }

    public PublicAccountDataCardFragment() {
        Lazy lazy;
        QQAppInterface Sh = Sh();
        this.pam = Sh != null ? (IPublicAccountDataManager) Sh.getRuntimeService(IPublicAccountDataManager.class, "all") : null;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.biz.pubaccount.accountdetail.model.i>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$accountDataCardViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.biz.pubaccount.accountdetail.model.i invoke() {
                return new com.tencent.biz.pubaccount.accountdetail.model.i();
            }
        });
        this.accountDataCardViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(PublicAccountDataCardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(QPublicBaseFragment.TAG, 1, "startOrStopFun is clicked =");
        com.tencent.biz.pubaccount.accountdetail.model.i fi5 = this$0.fi();
        if (fi5 != null) {
            fi5.R1(this$0.uin);
        }
    }

    private final Group Bi() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(zi());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Ci() {
        v vVar = new v(R.layout.d2c);
        vVar.x(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublicAccountDataCardFragment.Di(PublicAccountDataCardFragment.this, view);
            }
        });
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(PublicAccountDataCardFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(QPublicBaseFragment.TAG, 1, "startOrStopFun is clicked =");
        com.tencent.biz.pubaccount.accountdetail.model.i fi5 = this$0.fi();
        if (fi5 != null) {
            fi5.d2(this$0.uin);
        }
    }

    private final Group Ei() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Ci());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gi(PublicAccountDetailImpl detail) {
        PublicAccountDetailImpl publicAccountDetailImpl;
        PublicAccountDetailImpl publicAccountDetailImpl2 = this.accountDetail;
        boolean z16 = false;
        if (publicAccountDetailImpl2 != null && ((int) publicAccountDetailImpl2.getId()) == -1) {
            z16 = true;
        }
        if (z16 && (publicAccountDetailImpl = this.accountDetail) != null) {
            publicAccountDetailImpl.setId(0L);
        }
        IPublicAccountDataManager iPublicAccountDataManager = this.pam;
        if (iPublicAccountDataManager != null) {
            iPublicAccountDataManager.saveAccountDetailInfoCache(this.accountDetail);
        }
        IPublicAccountDataManager iPublicAccountDataManager2 = this.pam;
        if (iPublicAccountDataManager2 != null) {
            iPublicAccountDataManager2.updateAccountDetailEntity(this.accountDetail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi() {
        fi().a2(this.accountDetail);
        fi().b2(this);
        Ji();
    }

    private final void Ji() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            boolean z16 = false;
            if (publicAccountDetailImpl != null && publicAccountDetailImpl.followType == 1) {
                z16 = true;
            }
            if (z16) {
                showActionSheet();
                return;
            }
        }
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] ai5 = ai();
            th5.t0((Group[]) Arrays.copyOf(ai5, ai5.length));
        }
    }

    private final List<com.tencent.mobileqq.widget.listitem.a<?>> Uh() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        ArrayList arrayList = null;
        List<mobileqq_mp$ButtonInfo> buttonInfo = publicAccountDetailImpl != null ? publicAccountDetailImpl.getButtonInfo() : null;
        if (buttonInfo != null && !buttonInfo.isEmpty()) {
            arrayList = new ArrayList();
            for (final mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo : buttonInfo) {
                String str = mobileqq_mp_buttoninfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str, "buttonInfo.name.get()");
                arrayList.add(xi(str, 0, "", new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$businessConfig$config$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MqqHandler mqqHandler;
                        if (mobileqq_mp$ButtonInfo.this.sub_button.has()) {
                            this.ui(mobileqq_mp$ButtonInfo.this);
                            return;
                        }
                        IPublicAccountManager iPublicAccountManager = (IPublicAccountManager) QRoute.api(IPublicAccountManager.class);
                        Context context = this.getContext();
                        QQAppInterface Sh = this.Sh();
                        String str2 = this.uin;
                        int i3 = mobileqq_mp$ButtonInfo.this.f247282id.get();
                        mqqHandler = this.mQQUiHandler;
                        iPublicAccountManager.handleButtonEvent("", context, Sh, str2, i3, null, mqqHandler, 2, new SessionInfo());
                    }
                }, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$businessConfig$config$2
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }));
            }
        }
        return arrayList;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Vh() {
        Class<? extends com.tencent.biz.pubaccount.accountdetail.model.c> cls;
        com.tencent.biz.pubaccount.accountdetail.model.c newInstance;
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        String str = publicAccountDetailImpl != null ? publicAccountDetailImpl.uin : null;
        if (str == null) {
            return null;
        }
        com.tencent.biz.pubaccount.accountdetail.model.d dVar = com.tencent.biz.pubaccount.accountdetail.model.d.f79120a;
        if (!dVar.a().containsKey(str) || (cls = dVar.a().get(str)) == null || (newInstance = cls.newInstance()) == null) {
            return null;
        }
        this.businessSwitchConfig = new x<>(new x.b.d(newInstance.getTitle()), new x.c.f(newInstance.getSwitchDefaultValue(), newInstance.getCheckedChangeListener()));
        newInstance.d(new WeakReference<>(this.businessSwitchConfig), new WeakReference<>(th()));
        return this.businessSwitchConfig;
    }

    private final com.tencent.mobileqq.widget.listitem.c<c.a.d, c.b.C8995c> Xh() {
        String str;
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        String str2 = publicAccountDetailImpl != null ? publicAccountDetailImpl.name : null;
        if (str2 == null) {
            str2 = "";
        }
        if (publicAccountDetailImpl != null) {
            boolean z16 = false;
            if (publicAccountDetailImpl != null && publicAccountDetailImpl.followType == 1) {
                z16 = true;
            }
            if (!z16) {
                str = "\u5df2\u505c\u7528";
                a aVar = new a(new c.a.d(str2, str, ""), new c.b.C8995c("", false, false, 4, null));
                aVar.R(new Function2<ImageView, String, Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$createAvatarMsgConfig$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str3) {
                        invoke2(imageView, str3);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r24v0, types: [android.widget.ImageView, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r4v0 */
                    /* JADX WARN: Type inference failed for: r4v1 */
                    /* JADX WARN: Type inference failed for: r4v2, types: [android.graphics.drawable.Drawable] */
                    /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.mobileqq.proavatar.QQProAvatarDrawable] */
                    /* JADX WARN: Type inference failed for: r4v4, types: [android.graphics.drawable.Drawable] */
                    /* JADX WARN: Type inference failed for: r4v5 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ImageView view, String str3) {
                        Long longOrNull;
                        Intrinsics.checkNotNullParameter(view, "view");
                        Intrinsics.checkNotNullParameter(str3, "<anonymous parameter 1>");
                        IPublicAccountChatsApi iPublicAccountChatsApi = (IPublicAccountChatsApi) QRoute.api(IPublicAccountChatsApi.class);
                        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(PublicAccountDataCardFragment.this.uin);
                        Integer publicAccountIcon = iPublicAccountChatsApi.getPublicAccountIcon(longOrNull);
                        Context context = PublicAccountDataCardFragment.this.getContext();
                        ?? r46 = 0;
                        r46 = 0;
                        Resources resources = context != null ? context.getResources() : null;
                        if (publicAccountIcon != null && resources != null) {
                            r46 = ResourcesCompat.getDrawable(resources, publicAccountIcon.intValue(), null);
                        }
                        if (r46 == 0) {
                            r46 = new QQProAvatarDrawable();
                            PublicAccountDataCardFragment publicAccountDataCardFragment = PublicAccountDataCardFragment.this;
                            r46.r(publicAccountDataCardFragment.getContext(), 1, publicAccountDataCardFragment.uin, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(640).a());
                        }
                        view.setImageDrawable(r46);
                    }
                });
                return aVar;
            }
        }
        str = "\u5df2\u542f\u7528";
        a aVar2 = new a(new c.a.d(str2, str, ""), new c.b.C8995c("", false, false, 4, null));
        aVar2.R(new Function2<ImageView, String, Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$createAvatarMsgConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str3) {
                invoke2(imageView, str3);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r24v0, types: [android.widget.ImageView, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v0 */
            /* JADX WARN: Type inference failed for: r4v1 */
            /* JADX WARN: Type inference failed for: r4v2, types: [android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.mobileqq.proavatar.QQProAvatarDrawable] */
            /* JADX WARN: Type inference failed for: r4v4, types: [android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r4v5 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageView view, String str3) {
                Long longOrNull;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(str3, "<anonymous parameter 1>");
                IPublicAccountChatsApi iPublicAccountChatsApi = (IPublicAccountChatsApi) QRoute.api(IPublicAccountChatsApi.class);
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(PublicAccountDataCardFragment.this.uin);
                Integer publicAccountIcon = iPublicAccountChatsApi.getPublicAccountIcon(longOrNull);
                Context context = PublicAccountDataCardFragment.this.getContext();
                ?? r46 = 0;
                r46 = 0;
                Resources resources = context != null ? context.getResources() : null;
                if (publicAccountIcon != null && resources != null) {
                    r46 = ResourcesCompat.getDrawable(resources, publicAccountIcon.intValue(), null);
                }
                if (r46 == 0) {
                    r46 = new QQProAvatarDrawable();
                    PublicAccountDataCardFragment publicAccountDataCardFragment = PublicAccountDataCardFragment.this;
                    r46.r(publicAccountDataCardFragment.getContext(), 1, publicAccountDataCardFragment.uin, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(640).a());
                }
                view.setImageDrawable(r46);
            }
        });
        return aVar2;
    }

    private final v Yh() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        final String str = publicAccountDetailImpl != null ? publicAccountDetailImpl.summary : null;
        if (str == null) {
            str = "";
        }
        v vVar = new v(R.layout.d2a);
        vVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.g
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PublicAccountDataCardFragment.Zh(str, view);
            }
        });
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(String summary, View view) {
        Intrinsics.checkNotNullParameter(summary, "$summary");
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.p9f);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(summary);
    }

    private final Group di() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Xh());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.c[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.c[] cVarArr = (com.tencent.mobileqq.widget.listitem.c[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(cVarArr, cVarArr.length));
    }

    private final Group ei() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Vh(), pi(), ki());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    private final com.tencent.biz.pubaccount.accountdetail.model.i fi() {
        return (com.tencent.biz.pubaccount.accountdetail.model.i) this.accountDataCardViewModel.getValue();
    }

    private final int gi(long peerUin) {
        aa recentContactService;
        RecentContactInfo next;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getRecentContactService()) == null) {
            return 0;
        }
        List<RecentContactInfo> a16 = recentContactService.a();
        List<RecentContactInfo> list = a16;
        int i3 = 1;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        ListIterator<RecentContactInfo> listIterator = a16.listIterator();
        while (listIterator.hasNext() && (next = listIterator.next()) != null) {
            if (next.peerUin == peerUin) {
                return i3;
            }
            i3++;
        }
        return 0;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ki() {
        x.b.d dVar = new x.b.d(ni(R.string.xah));
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        boolean z16 = false;
        if (publicAccountDetailImpl != null && publicAccountDetailImpl.isMute) {
            z16 = true;
        }
        return new x(dVar, new x.c.f(z16, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                PublicAccountDataCardFragment.li(PublicAccountDataCardFragment.this, compoundButton, z17);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(PublicAccountDataCardFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(QPublicBaseFragment.TAG, 1, "msgNoDisturb is clicked =" + z16);
        this$0.mi(z16);
    }

    private final void mi(boolean isChecked) {
        QQAppInterface Sh = Sh();
        BusinessHandler businessHandler = Sh != null ? Sh.getBusinessHandler(PublicAccountSettingHandler.class.getName()) : null;
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.biz.pubaccount.handler.PublicAccountSettingHandler");
        ((PublicAccountSettingHandler) businessHandler).K2(Long.parseLong(this.uin), isChecked ? 1 : 0, new c(isChecked));
    }

    private final Group oi() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Yh());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new v[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        v[] vVarArr = (v[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(vVarArr, vVarArr.length));
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> pi() {
        String str;
        if (!this.showTopItem) {
            return null;
        }
        this.setTopConfig = new x<>(new x.b.d(ni(R.string.xak)), new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PublicAccountDataCardFragment.qi(PublicAccountDataCardFragment.this, compoundButton, z16);
            }
        }));
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null && (str = publicAccountDetailImpl.uid) != null) {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).getTopState(str, new d());
        }
        return this.setTopConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(PublicAccountDataCardFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(QPublicBaseFragment.TAG, 1, "setCurFunTop is clicked =" + z16);
        com.tencent.biz.pubaccount.accountdetail.model.i fi5 = this$0.fi();
        if (fi5 != null) {
            fi5.c2("", "");
        }
    }

    private final <L extends x.b, R extends x.c> x<L, R> ri(x<L, R> xVar, final Function0<Unit> function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PublicAccountDataCardFragment.si(Ref.BooleanRef.this, function0, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(Ref.BooleanRef firstExpo, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(firstExpo, "$firstExpo");
        Intrinsics.checkNotNullParameter(it, "it");
        if (firstExpo.element) {
            firstExpo.element = false;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(PublicAccountDataCardFragment this$0, List list, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        try {
            if (this$0.mActionSheetClicked) {
                return;
            }
            this$0.mActionSheetClicked = true;
            if (i3 == 0) {
                this$0.mActionSheetClicked = false;
                return;
            }
            com.tencent.biz.ui.c cVar = (com.tencent.biz.ui.c) list.get(i3 - 1);
            if (cVar == null) {
                this$0.mActionSheetClicked = false;
            } else {
                this$0.ci(cVar);
                actionSheet.dismiss();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(PublicAccountDataCardFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mActionSheetClicked = false;
    }

    private final x<x.b.d, x.c.g> xi(String leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, final Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublicAccountDataCardFragment.yi(Function0.this, view);
            }
        });
        ri(xVar, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$singleLineConfig$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0<Unit> function0 = onExpo;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        return xVar;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> zi() {
        v vVar = new v(R.layout.d2b);
        vVar.x(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublicAccountDataCardFragment.Ai(PublicAccountDataCardFragment.this, view);
            }
        });
        return vVar;
    }

    public final void Ii(int followType) {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            publicAccountDetailImpl.followType = followType;
        }
        this.reloadTime++;
        Ji();
        MsgListPluginEntity entityByUin = ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin(QPublicBaseFragment.TAG, Long.parseLong(this.uin));
        if (entityByUin != null) {
            entityByUin.isEnable = followType == 1;
            ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).updateData(QPublicBaseFragment.TAG, entityByUin);
        }
    }

    public final QQAppInterface Sh() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    public final x<x.b.d, x.c.f> hi() {
        return this.setTopConfig;
    }

    public final void ii(String uin, boolean updateUI) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPublicAccountDataManager iPublicAccountDataManager = this.pam;
        IPublicAccountDetail findAccountDetailInfoCache = iPublicAccountDataManager != null ? iPublicAccountDataManager.findAccountDetailInfoCache(uin) : null;
        PublicAccountDetailImpl publicAccountDetailImpl = findAccountDetailInfoCache instanceof PublicAccountDetailImpl ? (PublicAccountDetailImpl) findAccountDetailInfoCache : null;
        this.accountDetail = publicAccountDetailImpl;
        if (publicAccountDetailImpl != null && updateUI) {
            QLog.d(QPublicBaseFragment.TAG, 1, "load data accountDetail is not null");
            Hi();
        }
        PublicAccountStQWebServletWrapper.getAccountDetail(Long.valueOf(Long.parseLong(uin)), null, new b(updateUI, uin));
    }

    public final String ni(int resId) {
        String string = BaseApplication.context.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        fi().Z1();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Gi(this.accountDetail);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
    
        if (r4.getBooleanExtra("chatPage", false) == true) goto L12;
     */
    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            z16 = true;
        }
        z16 = false;
        this.fromChatPage = z16;
        String valueOf = String.valueOf(intent != null ? intent.getStringExtra("uin") : null);
        this.uin = valueOf;
        ji(this, valueOf, false, 2, null);
    }

    protected final void showActionSheet() {
        if (this.accountDetail == null) {
            QLog.d(PublicAccountDetailActivityImpl.TAG, 1, "accountDetail == null");
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("accountDetail.uid:");
            PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
            Intrinsics.checkNotNull(publicAccountDetailImpl);
            sb5.append(publicAccountDetailImpl.uid);
            QLog.d(PublicAccountDetailActivityImpl.TAG, 2, sb5.toString());
        }
        PublicAccountDetailImpl publicAccountDetailImpl2 = this.accountDetail;
        Intrinsics.checkNotNull(publicAccountDetailImpl2);
        if (TextUtils.isEmpty(publicAccountDetailImpl2.uid)) {
            QLog.d(PublicAccountDetailActivityImpl.TAG, 1, "accountDetail.uid is empty!");
            Th(false, false);
            return;
        }
        IPublicAccountCommonMrg iPublicAccountCommonMrg = (IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class);
        PublicAccountDetailImpl publicAccountDetailImpl3 = this.accountDetail;
        Intrinsics.checkNotNull(publicAccountDetailImpl3);
        String str = publicAccountDetailImpl3.uid;
        Intrinsics.checkNotNullExpressionValue(str, "accountDetail!!.uid");
        iPublicAccountCommonMrg.getTopState(str, new e());
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment$c", "Ley/a;", "", "isSuccess", "", "code", "", "msg", "", "data", "", "i", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements ey.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f79019b;

        c(boolean z16) {
            this.f79019b = z16;
        }

        @Override // ey.a
        public void i(boolean isSuccess, int code, String msg2, Object data) {
            if (isSuccess) {
                PublicAccountInfo publicAccountInfo = new PublicAccountInfo();
                ArrayList<PublicAccountProfile> arrayList = new ArrayList<>();
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                PublicAccountDetailImpl publicAccountDetailImpl = PublicAccountDataCardFragment.this.accountDetail;
                if (publicAccountDetailImpl != null) {
                    publicAccountDetailImpl.isMute = this.f79019b;
                }
                PublicAccountDetailImpl publicAccountDetailImpl2 = PublicAccountDataCardFragment.this.accountDetail;
                String str = publicAccountDetailImpl2 != null ? publicAccountDetailImpl2.uid : null;
                String str2 = str == null ? "" : str;
                PublicAccountDetailImpl publicAccountDetailImpl3 = PublicAccountDataCardFragment.this.accountDetail;
                String str3 = publicAccountDetailImpl3 != null ? publicAccountDetailImpl3.name : null;
                String str4 = str3 == null ? "" : str3;
                String str5 = PublicAccountDataCardFragment.this.uin;
                PublicAccountProfile b16 = str5 != null ? com.tencent.biz.pubaccount.util.j.INSTANCE.b(Long.parseLong(str5), str2, str4, this.f79019b) : null;
                if (b16 != null) {
                    b16.accountPosUpdateTime = Long.valueOf(serverTimeMillis);
                }
                if (b16 != null) {
                    arrayList.add(b16);
                }
                publicAccountInfo.profiles = arrayList;
                com.tencent.biz.pubaccount.util.j.INSTANCE.l(publicAccountInfo, 0);
            }
        }
    }

    private final Group Fi() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Wh());
        List<com.tencent.mobileqq.widget.listitem.a<?>> Uh = Uh();
        if (Uh != null) {
            Iterator<com.tencent.mobileqq.widget.listitem.a<?>> it = Uh.iterator();
            while (it.hasNext()) {
                mutableListOf.add(it.next());
            }
        }
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(boolean isTop, boolean isTopAvailable) {
        this.showTopItem = false;
        if (gi(Long.parseLong(this.uin)) != 0) {
            ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
            PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
            Intrinsics.checkNotNull(publicAccountDetailImpl);
            if (serviceAccountFolderNTManager.j(publicAccountDetailImpl) && isTopAvailable) {
                this.showTopItem = true;
            }
        }
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] bi5 = bi();
            th5.t0((Group[]) Arrays.copyOf(bi5, bi5.length));
        }
    }

    public final Group[] ai() {
        return new Group[]{di(), oi(), Bi()};
    }

    public final Group[] bi() {
        return new Group[]{di(), oi(), Fi(), ei(), Ei()};
    }

    private final void ci(com.tencent.biz.ui.c menuItem) {
        if (menuItem != null) {
            try {
                String d16 = menuItem.d();
                int e16 = menuItem.e();
                if (Sh() == null || this.uin == null || this.mQQUiHandler == null) {
                    return;
                }
                ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).handleButtonEvent(d16, getContext(), Sh(), this.uin, e16, null, this.mQQUiHandler, 2, new SessionInfo());
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Wh() {
        return xi(ni(R.string.xai), 0, "", new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$checkDetailConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                if (PublicAccountDataCardFragment.this.getActivity() != null) {
                    PublicAccountDataCardFragment publicAccountDataCardFragment = PublicAccountDataCardFragment.this;
                    QLog.d(QPublicBaseFragment.TAG, 1, "checkDetailConfig is clicked =");
                    z16 = publicAccountDataCardFragment.fromChatPage;
                    if (!z16) {
                        if (publicAccountDataCardFragment.uin.equals("2062433139")) {
                            ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(publicAccountDataCardFragment.getContext(), "from_account_detail", true);
                            return;
                        }
                        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("mqqapi://im/chat?uin=" + publicAccountDataCardFragment.uin + "&chat_type=public_account&src_type=internal&version=1"));
                        intent.putExtra("big_brother_source_key", "biz_src_jc_aio");
                        intent.putExtra("FromDataCardFragment", true);
                        publicAccountDataCardFragment.startActivity(intent);
                        return;
                    }
                    publicAccountDataCardFragment.onBackEvent();
                }
            }
        }, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment$checkDetailConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final boolean ti(mobileqq_mp$ButtonInfo buttonInfo) {
        if (buttonInfo != null) {
            if ((buttonInfo.type.has() ? buttonInfo.type.get() : 0) == 2 && buttonInfo.url.has() && !TextUtils.isEmpty(buttonInfo.url.get())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ui(mobileqq_mp$ButtonInfo buttonInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        if (buttonInfo == null) {
            return;
        }
        if (!buttonInfo.key.has()) {
            str = "";
        } else {
            str = buttonInfo.key.get();
        }
        if (!buttonInfo.name.has()) {
            str2 = "";
        } else {
            str2 = buttonInfo.name.get();
        }
        com.tencent.biz.ui.c cVar = new com.tencent.biz.ui.c(str, str2, null, buttonInfo.f247282id.has() ? buttonInfo.f247282id.get() : 0);
        cVar.k(buttonInfo);
        List<mobileqq_mp$ButtonInfo> list = buttonInfo.sub_button.has() ? buttonInfo.sub_button.get() : null;
        if (list != null && list.size() > 0) {
            for (mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo : list) {
                if (ti(mobileqq_mp_buttoninfo)) {
                    if (!mobileqq_mp_buttoninfo.key.has()) {
                        str3 = "";
                    } else {
                        str3 = mobileqq_mp_buttoninfo.key.get();
                    }
                    if (!mobileqq_mp_buttoninfo.name.has()) {
                        str4 = "";
                    } else {
                        str4 = mobileqq_mp_buttoninfo.name.get();
                    }
                    com.tencent.biz.ui.c cVar2 = new com.tencent.biz.ui.c(str3, str4, null, mobileqq_mp_buttoninfo.f247282id.has() ? mobileqq_mp_buttoninfo.f247282id.get() : 0);
                    cVar2.k(mobileqq_mp_buttoninfo);
                    cVar.a(cVar2);
                }
            }
        }
        final List<com.tencent.biz.ui.c> h16 = cVar.h();
        if (h16 == null || h16.size() <= 0) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setRoundCornerTop(true);
        actionSheet.addButton(cVar.i(), 11);
        for (com.tencent.biz.ui.c cVar3 : h16) {
            if (cVar3 != null) {
                String c16 = cVar3.c();
                if (!TextUtils.isEmpty(c16)) {
                    actionSheet.addButtonWithLeftUrlIcon(cVar3.i(), c16);
                } else {
                    actionSheet.addButton(cVar3.i());
                }
            }
        }
        actionSheet.addCancelButton(R.string.xag);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                PublicAccountDataCardFragment.vi(PublicAccountDataCardFragment.this, h16, actionSheet, view, i3);
            }
        });
        actionSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PublicAccountDataCardFragment.wi(PublicAccountDataCardFragment.this, dialogInterface);
            }
        });
        actionSheet.show();
    }

    public static /* synthetic */ void ji(PublicAccountDataCardFragment publicAccountDataCardFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        publicAccountDataCardFragment.ii(str, z16);
    }
}
