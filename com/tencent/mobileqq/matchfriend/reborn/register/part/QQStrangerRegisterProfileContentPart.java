package com.tencent.mobileqq.matchfriend.reborn.register.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.activity.QQStrangerPublicFragmentActivity;
import com.tencent.mobileqq.matchfriend.reborn.register.fragment.QQStrangerRegisterTagFragment;
import com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterProfileContentPart;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Birthday;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$SetMiniUserInfoRsp;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 z2\u00020\u0001:\u0001{B\u0007\u00a2\u0006\u0004\bx\u0010yJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0003J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u000e\u0010\u001c\u001a\u0004\u0018\u00010\n*\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\bH\u0003J\b\u0010#\u001a\u00020\bH\u0003J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0003J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020)H\u0002JD\u00103\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u00022\b\u0010-\u001a\u0004\u0018\u00010\u00022\b\u0010.\u001a\u0004\u0018\u00010\u00022\b\u0010/\u001a\u0004\u0018\u00010\u00022\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000100H\u0002J\b\u00104\u001a\u00020\bH\u0002J\u001a\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u00107\u001a\u00020\bH\u0002R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R&\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u00020>j\b\u0012\u0004\u0012\u00020\u0002`?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010LR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010cR\u0018\u0010m\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010HR\u0018\u0010o\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010LR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010w\u001a\u00020t8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010v\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterProfileContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "onPartDestroy", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "ga", "Ba", "va", "dx", "la", "ea", "position", "Da", "", "isMale", "Ja", "wa", "za", "na", "pa", "", "gender", "ua", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$Birthday;", "birthday", "ma", "title", "content", "leftText", "rightText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Ea", "Ia", "icon", "Ga", "ca", "", "d", "Ljava/util/List;", "adjectivalSectionList", "e", "nounSectionList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "avatarList", "Lv82/b;", tl.h.F, "Lv82/b;", "viewModel", "i", "Landroid/view/View;", "partRootView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "editNickInputView", BdhLogUtil.LogTag.Tag_Conn, "genderContainer", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "genderImageView", "E", "genderTextView", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "avatarRecyclerView", "Lt82/b;", "G", "Lt82/b;", "avatarAdapter", "Lnb0/b;", "H", "Lnb0/b;", "snapHelper", "Lu82/b;", "I", "Lu82/b;", "inputDialog", "Landroid/app/Dialog;", "J", "Landroid/app/Dialog;", "loadingDialog", "K", "selectedPosition", "L", "constellationContainer", "M", "constellationTextView", "Lcom/tencent/relation/common/servlet/b;", "N", "Lcom/tencent/relation/common/servlet/b;", "businessObserver", "Landroid/view/View$OnTouchListener;", "P", "Landroid/view/View$OnTouchListener;", "buttonTouchListener", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerRegisterProfileContentPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private View genderContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView genderImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView genderTextView;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView avatarRecyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private t82.b avatarAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private nb0.b snapHelper;

    /* renamed from: I, reason: from kotlin metadata */
    private u82.b inputDialog;

    /* renamed from: J, reason: from kotlin metadata */
    private Dialog loadingDialog;

    /* renamed from: K, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: L, reason: from kotlin metadata */
    private View constellationContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView constellationTextView;

    /* renamed from: N, reason: from kotlin metadata */
    private final com.tencent.relation.common.servlet.b businessObserver;

    /* renamed from: P, reason: from kotlin metadata */
    private final View.OnTouchListener buttonTouchListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<String> adjectivalSectionList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<String> nounSectionList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<String> avatarList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private v82.b viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View partRootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView editNickInputView;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterProfileContentPart$b", "Lq72/a;", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$SetMiniUserInfoRsp;", "rsp", "", "p", "", "msg", "o", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends q72.a {
        b() {
        }

        @Override // q72.a
        public void o(String msg2) {
            QLog.i("QQStrangerRegisterContentPart", 1, "handleSetMiniUserInfoFail msg=" + msg2);
            QQStrangerRegisterProfileContentPart.this.ca();
            if (TextUtils.isEmpty(msg2)) {
                return;
            }
            QQStrangerRegisterProfileContentPart.this.Ga(1, msg2);
        }

        @Override // q72.a
        public void p(userInfo$SetMiniUserInfoRsp rsp) {
            Resources resources;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.i("QQStrangerRegisterContentPart", 1, "handleSetMiniUserInfoSuccess, value = " + rsp.value.get());
            QQStrangerRegisterProfileContentPart.this.ca();
            if (rsp.value.get() == 0) {
                QQStrangerRegisterProfileContentPart.this.Ia();
            } else {
                if (rsp.value.get() != 1) {
                    QQStrangerRegisterProfileContentPart.this.Ga(1, rsp.document_config.body.get());
                    return;
                }
                QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart = QQStrangerRegisterProfileContentPart.this;
                Activity activity = qQStrangerRegisterProfileContentPart.getActivity();
                qQStrangerRegisterProfileContentPart.Ga(1, (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.x3e));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterProfileContentPart$d", "Lt82/d;", "", "position", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements t82.d {
        d() {
        }

        @Override // t82.d
        public void onClick(int position) {
            RecyclerView recyclerView = QQStrangerRegisterProfileContentPart.this.avatarRecyclerView;
            t82.b bVar = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView = null;
            }
            Integer a16 = a.a(recyclerView);
            if ((a16 != null && a16.intValue() == position) || a16 == null) {
                return;
            }
            QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart = QQStrangerRegisterProfileContentPart.this;
            int intValue = position - a16.intValue();
            RecyclerView recyclerView2 = qQStrangerRegisterProfileContentPart.avatarRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView2 = null;
            }
            t82.b bVar2 = qQStrangerRegisterProfileContentPart.avatarAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            } else {
                bVar = bVar2;
            }
            recyclerView2.smoothScrollBy(intValue * bVar.m0(), 0);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterProfileContentPart$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            QQStrangerRegisterProfileContentPart.this.la(dx5);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterProfileContentPart$f", "Lu82/c;", "", "text", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class f implements u82.c {
        f() {
        }

        @Override // u82.c
        public void a(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            TextView textView = QQStrangerRegisterProfileContentPart.this.editNickInputView;
            if (textView == null) {
                return;
            }
            textView.setText(text);
        }
    }

    public QQStrangerRegisterProfileContentPart() {
        com.tencent.mobileqq.matchfriend.reborn.config.c cVar = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a;
        this.adjectivalSectionList = cVar.c().f();
        this.nounSectionList = cVar.c().g();
        this.avatarList = new ArrayList<>();
        this.businessObserver = new b();
        this.buttonTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.m
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean ba5;
                ba5 = QQStrangerRegisterProfileContentPart.ba(view, motionEvent);
                return ba5;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(QQStrangerRegisterProfileContentPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pa();
    }

    private final void Ba() {
        String str;
        if ((!this.adjectivalSectionList.isEmpty()) && (!this.nounSectionList.isEmpty())) {
            Random.Companion companion = Random.INSTANCE;
            int nextInt = companion.nextInt(0, this.adjectivalSectionList.size());
            int nextInt2 = companion.nextInt(0, this.nounSectionList.size());
            String str2 = this.adjectivalSectionList.get(nextInt);
            String str3 = this.nounSectionList.get(nextInt2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) str2);
            sb5.append((Object) str3);
            str = sb5.toString();
        } else {
            str = "";
        }
        View view = this.partRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
            view = null;
        }
        TextView textView = (TextView) view.findViewById(R.id.ojq);
        this.editNickInputView = textView;
        if (textView != null) {
            textView.setBackgroundColor(0);
        }
        TextView textView2 = this.editNickInputView;
        if (textView2 != null) {
            textView2.setText(str);
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        this.inputDialog = new u82.b(activity, new f());
        y82.a.b().f(this.editNickInputView, "em_bas_nickname_input_field");
        TextView textView3 = this.editNickInputView;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQStrangerRegisterProfileContentPart.Ca(QQStrangerRegisterProfileContentPart.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(QQStrangerRegisterProfileContentPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        y82.a.b().d(this$0.editNickInputView, "em_bas_nickname_input_field");
        u82.b bVar = this$0.inputDialog;
        if (bVar != null) {
            TextView textView = this$0.editNickInputView;
            bVar.h(String.valueOf(textView != null ? textView.getText() : null));
        }
    }

    private final void Da(int position) {
        this.selectedPosition = position;
        t82.b bVar = this.avatarAdapter;
        v82.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            bVar = null;
        }
        String j06 = bVar.j0(position);
        v82.b bVar3 = this.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar3 = null;
        }
        bVar3.W1(j06);
        v82.b bVar4 = this.viewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            bVar2 = bVar4;
        }
        bVar2.b2(Boolean.valueOf(com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.e(j06)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea(final String title, final String content, final String leftText, final String rightText, final DialogInterface.OnClickListener onConfirm, final DialogInterface.OnClickListener onCancel) {
        if (getActivity() == null || getActivity().isFinishing()) {
            QLog.i("QQStrangerRegisterContentPart", 1, "showConfirmDialog, but activity is null or finishing.");
        }
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.l
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerRegisterProfileContentPart.Fa(QQStrangerRegisterProfileContentPart.this, title, content, leftText, rightText, onConfirm, onCancel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(QQStrangerRegisterProfileContentPart this$0, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogUtil.createCustomDialog(this$0.getActivity(), 0, str, str2, str3, str4, onClickListener, onClickListener2).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga(final int icon, final String content) {
        final Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.h
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerRegisterProfileContentPart.Ha(activity, icon, content);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(Activity it, int i3, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        QQToast.makeText(it, i3, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia() {
        Intent intent = new Intent();
        v82.b bVar = this.viewModel;
        v82.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        intent.putExtra("key_is_new_user", bVar.getIsNewUser());
        v82.b bVar3 = this.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar3 = null;
        }
        intent.putExtra("key_open_id", bVar3.getOpenId());
        v82.b bVar4 = this.viewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar4 = null;
        }
        intent.putExtra("key_register_gender", bVar4.P1().getValue());
        v82.b bVar5 = this.viewModel;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar5 = null;
        }
        userInfo$Birthday value = bVar5.M1().getValue();
        intent.putExtra("key_register_birthday", value != null ? value.toByteArray() : null);
        v82.b bVar6 = this.viewModel;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar6 = null;
        }
        intent.putExtra("key_register_nickname", bVar6.getNickName());
        v82.b bVar7 = this.viewModel;
        if (bVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar7 = null;
        }
        intent.putExtra("key_register_avatar_url", bVar7.getAvatar());
        v82.b bVar8 = this.viewModel;
        if (bVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            bVar2 = bVar8;
        }
        intent.putExtra("key_register_is_zplan_head", bVar2.getIsZplanHead());
        Activity activity = getActivity();
        if (activity != null) {
            QQStrangerPublicFragmentActivity.INSTANCE.b(activity, intent, QQStrangerRegisterTagFragment.class, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(QQStrangerRegisterProfileContentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.avatarRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
            recyclerView = null;
        }
        View b16 = a.b(recyclerView);
        if (b16 != null) {
            int left = (b16.getLeft() + b16.getRight()) / 2;
            RecyclerView recyclerView3 = this$0.avatarRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView3 = null;
            }
            int left2 = recyclerView3.getLeft();
            RecyclerView recyclerView4 = this$0.avatarRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView4 = null;
            }
            int right = left - ((left2 + recyclerView4.getRight()) / 2);
            RecyclerView recyclerView5 = this$0.avatarRecyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
            } else {
                recyclerView2 = recyclerView5;
            }
            recyclerView2.scrollBy(right, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ba(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.5f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        try {
            getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerRegisterProfileContentPart.da(QQStrangerRegisterProfileContentPart.this);
                }
            });
        } catch (Throwable th5) {
            QLog.e("QQStrangerRegisterContentPart", 1, "dismissLoading error. ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(QQStrangerRegisterProfileContentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final View ea(View view) {
        t82.b bVar = this.avatarAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            bVar = null;
        }
        return view.findViewById(bVar.getScaleViewId());
    }

    private final void ga() {
        Activity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            v82.b bVar = this.viewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                bVar = null;
            }
            MutableLiveData<Boolean> N1 = bVar.N1();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterProfileContentPart$initObserver$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    if (bool != null) {
                        QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart = QQStrangerRegisterProfileContentPart.this;
                        if (bool.booleanValue()) {
                            TextView textView = qQStrangerRegisterProfileContentPart.editNickInputView;
                            v82.b bVar2 = null;
                            CharSequence text = textView != null ? textView.getText() : null;
                            if (text == null || text.length() == 0) {
                                QQToast.makeText(qQStrangerRegisterProfileContentPart.getActivity(), "\u8bf7\u8f93\u5165\u6635\u79f0", 0).show();
                                return;
                            }
                            if (!NetworkUtil.isNetworkAvailable()) {
                                qQStrangerRegisterProfileContentPart.Ga(1, qQStrangerRegisterProfileContentPart.getActivity().getResources().getString(R.string.x0c));
                                return;
                            }
                            v82.b bVar3 = qQStrangerRegisterProfileContentPart.viewModel;
                            if (bVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                bVar3 = null;
                            }
                            TextView textView2 = qQStrangerRegisterProfileContentPart.editNickInputView;
                            bVar3.Z1(String.valueOf(textView2 != null ? textView2.getText() : null));
                            v82.b bVar4 = qQStrangerRegisterProfileContentPart.viewModel;
                            if (bVar4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                bVar2 = bVar4;
                            }
                            bVar2.g2();
                        }
                    }
                }
            };
            N1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQStrangerRegisterProfileContentPart.ha(Function1.this, obj);
                }
            });
            v82.b bVar2 = this.viewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                bVar2 = null;
            }
            MutableLiveData<Short> P1 = bVar2.P1();
            final Function1<Short, Unit> function12 = new Function1<Short, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterProfileContentPart$initObserver$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Short sh5) {
                    invoke2(sh5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Short it) {
                    QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart = QQStrangerRegisterProfileContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qQStrangerRegisterProfileContentPart.ua(it.shortValue());
                }
            };
            P1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQStrangerRegisterProfileContentPart.ia(Function1.this, obj);
                }
            });
            v82.b bVar3 = this.viewModel;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                bVar3 = null;
            }
            MutableLiveData<userInfo$Birthday> M1 = bVar3.M1();
            final Function1<userInfo$Birthday, Unit> function13 = new Function1<userInfo$Birthday, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterProfileContentPart$initObserver$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(userInfo$Birthday userinfo_birthday) {
                    invoke2(userinfo_birthday);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(userInfo$Birthday it) {
                    QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart = QQStrangerRegisterProfileContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qQStrangerRegisterProfileContentPart.ma(it);
                }
            };
            M1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQStrangerRegisterProfileContentPart.ja(Function1.this, obj);
                }
            });
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.businessObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma(userInfo$Birthday birthday) {
        TextView textView = this.constellationTextView;
        if (textView == null) {
            return;
        }
        textView.setText(Utils.t(birthday.month.get(), birthday.day.get()));
    }

    private final void na() {
        if (getActivity() == null) {
            return;
        }
        v82.b bVar = this.viewModel;
        v82.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        if (bVar.getHasModifyBirthday()) {
            Ea(null, HardCodeUtil.qqStr(R.string.x3c), HardCodeUtil.qqStr(R.string.x28), null, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.s
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQStrangerRegisterProfileContentPart.oa(dialogInterface, i3);
                }
            });
            return;
        }
        com.tencent.mobileqq.widget.selectorview.a aVar = new com.tencent.mobileqq.widget.selectorview.a(getActivity());
        v82.b bVar3 = this.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            bVar2 = bVar3;
        }
        userInfo$Birthday value = bVar2.M1().getValue();
        if (value != null) {
            aVar.E(value.year.get(), value.month.get(), value.day.get());
        }
        aVar.k(HardCodeUtil.qqStr(R.string.x3k));
        if (aVar.e() == null) {
            aVar.i(new c(aVar));
        }
        View view = this.constellationContainer;
        if (view != null) {
            view.setClickable(false);
        }
        aVar.m();
    }

    private final void pa() {
        if (getActivity() == null) {
            return;
        }
        v82.b bVar = this.viewModel;
        v82.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        if (bVar.getHasModifyGender()) {
            Ea(null, HardCodeUtil.qqStr(R.string.x3d), HardCodeUtil.qqStr(R.string.x28), null, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQStrangerRegisterProfileContentPart.qa(dialogInterface, i3);
                }
            });
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(R.string.x3n);
        v82.b bVar3 = this.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar3 = null;
        }
        Short value = bVar3.P1().getValue();
        actionSheet.addRadioButton(R.string.x2y, value != null && value.shortValue() == 0);
        v82.b bVar4 = this.viewModel;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            bVar2 = bVar4;
        }
        Short value2 = bVar2.P1().getValue();
        actionSheet.addRadioButton(R.string.x27, value2 != null && value2.shortValue() == 1);
        actionSheet.addCancelButton(R.string.wzk);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.g
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                QQStrangerRegisterProfileContentPart.ra(QQStrangerRegisterProfileContentPart.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(final QQStrangerRegisterProfileContentPart this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        final Ref.ShortRef shortRef = new Ref.ShortRef();
        boolean z16 = false;
        if (i3 == 0) {
            shortRef.element = (short) 0;
        } else if (i3 == 1) {
            shortRef.element = (short) 1;
        }
        v82.b bVar = this$0.viewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        Short value = bVar.P1().getValue();
        if (value != null && shortRef.element == value.shortValue()) {
            z16 = true;
        }
        if (!z16) {
            this$0.Ea(HardCodeUtil.qqStr(R.string.x3m), HardCodeUtil.qqStr(R.string.x3l), HardCodeUtil.qqStr(R.string.wyl), HardCodeUtil.qqStr(R.string.wym), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    QQStrangerRegisterProfileContentPart.sa(QQStrangerRegisterProfileContentPart.this, shortRef, dialogInterface, i16);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    QQStrangerRegisterProfileContentPart.ta(dialogInterface, i16);
                }
            });
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(QQStrangerRegisterProfileContentPart this$0, Ref.ShortRef selectedGender, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedGender, "$selectedGender");
        v82.b bVar = this$0.viewModel;
        v82.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        bVar.P1().postValue(Short.valueOf(selectedGender.element));
        v82.b bVar3 = this$0.viewModel;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            bVar2 = bVar3;
        }
        bVar2.f2(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(short gender) {
        Drawable drawable;
        String str;
        TextView textView = this.genderTextView;
        if (textView != null) {
            if (gender == 1) {
                str = "\u5973\u751f";
            } else {
                str = "\u7537\u751f";
            }
            textView.setText(str);
        }
        if (gender == 1) {
            drawable = getActivity().getResources().getDrawable(R.drawable.qui_female);
        } else {
            drawable = getActivity().getResources().getDrawable(R.drawable.qui_male);
        }
        Drawable f16 = cn.f(drawable);
        f16.setColorFilter(null);
        ImageView imageView = this.genderImageView;
        if (imageView != null) {
            imageView.setImageDrawable(f16);
        }
        Ja(gender == 0);
    }

    private final void va() {
        View view = this.partRootView;
        RecyclerView recyclerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.oic);
        Intrinsics.checkNotNullExpressionValue(findViewById, "partRootView.findViewByI\u2026.id.avatar_recycler_view)");
        this.avatarRecyclerView = (RecyclerView) findViewById;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        t82.b bVar = new t82.b(context, getPartRootView());
        this.avatarAdapter = bVar;
        bVar.s0(new d());
        RecyclerView recyclerView2 = this.avatarRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
            recyclerView2 = null;
        }
        t82.b bVar2 = this.avatarAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            bVar2 = null;
        }
        recyclerView2.setAdapter(bVar2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        linearLayoutManager.scrollToPosition(LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.addOnScrollListener(new e());
        nb0.b bVar3 = new nb0.b(17);
        bVar3.m(3.0f);
        this.snapHelper = bVar3;
        RecyclerView recyclerView3 = this.avatarRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        bVar3.attachToRecyclerView(recyclerView);
    }

    private final void wa() {
        View view = this.partRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.ojf);
        this.constellationContainer = findViewById;
        if (findViewById != null) {
            findViewById.setOnTouchListener(this.buttonTouchListener);
        }
        View view3 = this.constellationContainer;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    QQStrangerRegisterProfileContentPart.xa(QQStrangerRegisterProfileContentPart.this, view4);
                }
            });
        }
        View view4 = this.partRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
        } else {
            view2 = view4;
        }
        this.constellationTextView = (TextView) view2.findViewById(R.id.ojg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(QQStrangerRegisterProfileContentPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.na();
    }

    private final void za() {
        View view = this.partRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.ojx);
        this.genderContainer = findViewById;
        if (findViewById != null) {
            findViewById.setOnTouchListener(this.buttonTouchListener);
        }
        View view3 = this.genderContainer;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    QQStrangerRegisterProfileContentPart.Aa(QQStrangerRegisterProfileContentPart.this, view4);
                }
            });
        }
        View view4 = this.partRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
            view4 = null;
        }
        this.genderImageView = (ImageView) view4.findViewById(R.id.ojz);
        View view5 = this.partRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partRootView");
        } else {
            view2 = view5;
        }
        this.genderTextView = (TextView) view2.findViewById(R.id.f163147ok1);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QQStrangerRegisterContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        QLog.i("QQStrangerRegisterContentPart", 1, "onActivityResult, requestCode=" + requestCode + ", resultCode=" + resultCode);
        if (resultCode == -1 && requestCode == 1001) {
            getActivity().setResult(-1);
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        RecyclerView recyclerView = this.avatarRecyclerView;
        if (recyclerView == null) {
            return;
        }
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
            recyclerView = null;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterProfileContentPart$onConfigurationChanged$2
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                RecyclerView recyclerView2 = QQStrangerRegisterProfileContentPart.this.avatarRecyclerView;
                RecyclerView recyclerView3 = null;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                    recyclerView2 = null;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (layoutManager != null) {
                    i3 = QQStrangerRegisterProfileContentPart.this.selectedPosition;
                    View findViewByPosition = layoutManager.findViewByPosition(i3);
                    if (findViewByPosition != null) {
                        QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart = QQStrangerRegisterProfileContentPart.this;
                        int left = (findViewByPosition.getLeft() + findViewByPosition.getRight()) / 2;
                        RecyclerView recyclerView4 = qQStrangerRegisterProfileContentPart.avatarRecyclerView;
                        if (recyclerView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                            recyclerView4 = null;
                        }
                        int left2 = recyclerView4.getLeft();
                        RecyclerView recyclerView5 = qQStrangerRegisterProfileContentPart.avatarRecyclerView;
                        if (recyclerView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                            recyclerView5 = null;
                        }
                        int right = left - ((left2 + recyclerView5.getRight()) / 2);
                        RecyclerView recyclerView6 = qQStrangerRegisterProfileContentPart.avatarRecyclerView;
                        if (recyclerView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                        } else {
                            recyclerView3 = recyclerView6;
                        }
                        recyclerView3.scrollBy(right, 0);
                    }
                }
            }
        }, 100L);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        ViewModel viewModel = getViewModel(v82.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QQStrangerR\u2026terProfileVM::class.java)");
        this.viewModel = (v82.b) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.businessObserver);
        }
    }

    private final void Ja(boolean isMale) {
        List<String> c16;
        if (isMale) {
            c16 = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.c().e();
        } else {
            c16 = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.c().c();
        }
        Collections.shuffle(c16);
        RecyclerView recyclerView = null;
        if (!c16.isEmpty()) {
            t82.b bVar = this.avatarAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                bVar = null;
            }
            bVar.t0(Random.INSTANCE.nextInt(0, c16.size()));
            t82.b bVar2 = this.avatarAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                bVar2 = null;
            }
            bVar2.r0(c16, com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.c().getUserZplanAvatarUrl());
            nb0.b bVar3 = this.snapHelper;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snapHelper");
                bVar3 = null;
            }
            bVar3.l(LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        }
        RecyclerView recyclerView2 = this.avatarRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.t
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerRegisterProfileContentPart.Ka(QQStrangerRegisterProfileContentPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:60:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void la(int dx5) {
        int i3;
        View ea5;
        View ea6;
        View findViewByPosition;
        View ea7;
        View ea8;
        RecyclerView recyclerView = this.avatarRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
            recyclerView = null;
        }
        float width = recyclerView.getWidth() / 2.0f;
        RecyclerView recyclerView3 = this.avatarRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
            recyclerView3 = null;
        }
        float height = recyclerView3.getHeight() / 2.0f;
        if (dx5 > 0) {
            t82.b bVar = this.avatarAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                bVar = null;
            }
            float m06 = width - (bVar.m0() / 2);
            RecyclerView recyclerView4 = this.avatarRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView4 = null;
            }
            View findChildViewUnder = recyclerView4.findChildViewUnder(m06, height);
            if (findChildViewUnder == null) {
                return;
            }
            RecyclerView recyclerView5 = this.avatarRecyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView5 = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView5.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            int position = layoutManager.getPosition(findChildViewUnder);
            View ea9 = ea(findChildViewUnder);
            if (ea9 != null) {
                float left = m06 - findChildViewUnder.getLeft();
                t82.b bVar2 = this.avatarAdapter;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar2 = null;
                }
                a.e(ea9, 1.3833333f - ((left / bVar2.m0()) * 0.38333333f), 0.0f, 2, null);
                float left2 = m06 - findChildViewUnder.getLeft();
                t82.b bVar3 = this.avatarAdapter;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar3 = null;
                }
                a.c(ea9, 1.0f - ((left2 / bVar3.m0()) * 0.4f));
            }
            RecyclerView recyclerView6 = this.avatarRecyclerView;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView6 = null;
            }
            RecyclerView.LayoutManager layoutManager2 = recyclerView6.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2);
            View findViewByPosition2 = layoutManager2.findViewByPosition(position + 1);
            if (findViewByPosition2 != null && (ea8 = ea(findViewByPosition2)) != null) {
                t82.b bVar4 = this.avatarAdapter;
                if (bVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar4 = null;
                }
                float m07 = width + (bVar4.m0() / 2);
                float left3 = m07 - findViewByPosition2.getLeft();
                t82.b bVar5 = this.avatarAdapter;
                if (bVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar5 = null;
                }
                a.e(ea8, ((left3 / bVar5.m0()) * 0.38333333f) + 1, 0.0f, 2, null);
                float left4 = m07 - findViewByPosition2.getLeft();
                t82.b bVar6 = this.avatarAdapter;
                if (bVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar6 = null;
                }
                a.c(ea8, ((left4 / bVar6.m0()) * 0.4f) + 0.6f);
            }
            RecyclerView recyclerView7 = this.avatarRecyclerView;
            if (recyclerView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView7 = null;
            }
            RecyclerView.LayoutManager layoutManager3 = recyclerView7.getLayoutManager();
            if (layoutManager3 != null && (findViewByPosition = layoutManager3.findViewByPosition(position - 1)) != null && (ea7 = ea(findViewByPosition)) != null) {
                ea7.setScaleX(1.0f);
                ea7.setScaleY(1.0f);
                ea7.setAlpha(0.6f);
                ea7.setAlpha(0.6f);
            }
        } else if (dx5 < 0) {
            t82.b bVar7 = this.avatarAdapter;
            if (bVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                bVar7 = null;
            }
            float m08 = (bVar7.m0() / 2) + width;
            RecyclerView recyclerView8 = this.avatarRecyclerView;
            if (recyclerView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView8 = null;
            }
            View findChildViewUnder2 = recyclerView8.findChildViewUnder(m08, height);
            if (findChildViewUnder2 == null) {
                return;
            }
            RecyclerView recyclerView9 = this.avatarRecyclerView;
            if (recyclerView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView9 = null;
            }
            RecyclerView.LayoutManager layoutManager4 = recyclerView9.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager4);
            int position2 = layoutManager4.getPosition(findChildViewUnder2);
            View ea10 = ea(findChildViewUnder2);
            if (ea10 != null) {
                t82.b bVar8 = this.avatarAdapter;
                if (bVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar8 = null;
                }
                float m09 = width - (bVar8.m0() / 2);
                float left5 = findChildViewUnder2.getLeft() - m09;
                t82.b bVar9 = this.avatarAdapter;
                if (bVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar9 = null;
                }
                a.e(ea10, 1.3833333f - ((left5 / bVar9.m0()) * 0.38333333f), 0.0f, 2, null);
                float left6 = findChildViewUnder2.getLeft() - m09;
                t82.b bVar10 = this.avatarAdapter;
                if (bVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar10 = null;
                }
                a.c(ea10, 1.0f - ((left6 / bVar10.m0()) * 0.4f));
            }
            RecyclerView recyclerView10 = this.avatarRecyclerView;
            if (recyclerView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView10 = null;
            }
            RecyclerView.LayoutManager layoutManager5 = recyclerView10.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager5);
            View findViewByPosition3 = layoutManager5.findViewByPosition(position2 - 1);
            if (findViewByPosition3 != null && (ea6 = ea(findViewByPosition3)) != null) {
                t82.b bVar11 = this.avatarAdapter;
                if (bVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar11 = null;
                }
                float m010 = width - (bVar11.m0() / 2);
                float left7 = (findViewByPosition3.getLeft() + findViewByPosition3.getWidth()) - m010;
                t82.b bVar12 = this.avatarAdapter;
                if (bVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar12 = null;
                }
                a.e(ea6, ((left7 / bVar12.m0()) * 0.38333333f) + 1, 0.0f, 2, null);
                float left8 = findChildViewUnder2.getLeft() - m010;
                t82.b bVar13 = this.avatarAdapter;
                if (bVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    bVar13 = null;
                }
                a.c(ea6, ((left8 / bVar13.m0()) * 0.4f) + 0.6f);
            }
            RecyclerView recyclerView11 = this.avatarRecyclerView;
            if (recyclerView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                recyclerView11 = null;
            }
            RecyclerView.LayoutManager layoutManager6 = recyclerView11.getLayoutManager();
            if (layoutManager6 != null) {
                i3 = 1;
                View findViewByPosition4 = layoutManager6.findViewByPosition(position2 + 1);
                if (findViewByPosition4 != null && (ea5 = ea(findViewByPosition4)) != null) {
                    ea5.setScaleX(1.0f);
                    ea5.setScaleY(1.0f);
                    ea5.setAlpha(0.6f);
                    ea5.setAlpha(0.6f);
                }
                if (dx5 == 0) {
                    RecyclerView recyclerView12 = this.avatarRecyclerView;
                    if (recyclerView12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("avatarRecyclerView");
                    } else {
                        recyclerView2 = recyclerView12;
                    }
                    Integer a16 = a.a(recyclerView2);
                    Da(a16 != null ? a16.intValue() : i3);
                    return;
                }
                return;
            }
        }
        i3 = 1;
        if (dx5 == 0) {
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.oqh);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.register_content_part)");
            this.partRootView = findViewById;
        }
        za();
        wa();
        va();
        Ba();
        ga();
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterProfileContentPart$c", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements QActionSheet.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.a f245378e;

        c(com.tencent.mobileqq.widget.selectorview.a aVar) {
            this.f245378e = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(com.tencent.mobileqq.widget.selectorview.a selectorView, QQStrangerRegisterProfileContentPart this$0, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(selectorView, "$selectorView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            userInfo$Birthday userinfo_birthday = new userInfo$Birthday();
            userinfo_birthday.year.set(selectorView.D());
            userinfo_birthday.month.set(selectorView.B());
            userinfo_birthday.day.set(selectorView.A());
            v82.b bVar = this$0.viewModel;
            v82.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                bVar = null;
            }
            bVar.M1().postValue(userinfo_birthday);
            v82.b bVar3 = this$0.viewModel;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                bVar2 = bVar3;
            }
            bVar2.e2(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
        
            if (r4 == false) goto L38;
         */
        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onConfirm() {
            PBUInt32Field pBUInt32Field;
            PBUInt32Field pBUInt32Field2;
            PBUInt32Field pBUInt32Field3;
            v82.b bVar = QQStrangerRegisterProfileContentPart.this.viewModel;
            v82.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                bVar = null;
            }
            userInfo$Birthday value = bVar.M1().getValue();
            boolean z16 = false;
            if ((value == null || (pBUInt32Field3 = value.year) == null || pBUInt32Field3.get() != this.f245378e.D()) ? false : true) {
                v82.b bVar3 = QQStrangerRegisterProfileContentPart.this.viewModel;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    bVar3 = null;
                }
                userInfo$Birthday value2 = bVar3.M1().getValue();
                if ((value2 == null || (pBUInt32Field2 = value2.month) == null || pBUInt32Field2.get() != this.f245378e.B()) ? false : true) {
                    v82.b bVar4 = QQStrangerRegisterProfileContentPart.this.viewModel;
                    if (bVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        bVar2 = bVar4;
                    }
                    userInfo$Birthday value3 = bVar2.M1().getValue();
                    if (value3 != null && (pBUInt32Field = value3.day) != null && pBUInt32Field.get() == this.f245378e.A()) {
                        z16 = true;
                    }
                }
            }
            QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart = QQStrangerRegisterProfileContentPart.this;
            String qqStr = HardCodeUtil.qqStr(R.string.x3j);
            String qqStr2 = HardCodeUtil.qqStr(R.string.x3i);
            String qqStr3 = HardCodeUtil.qqStr(R.string.wyl);
            String qqStr4 = HardCodeUtil.qqStr(R.string.wym);
            final com.tencent.mobileqq.widget.selectorview.a aVar = this.f245378e;
            final QQStrangerRegisterProfileContentPart qQStrangerRegisterProfileContentPart2 = QQStrangerRegisterProfileContentPart.this;
            qQStrangerRegisterProfileContentPart.Ea(qqStr, qqStr2, qqStr3, qqStr4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.v
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQStrangerRegisterProfileContentPart.c.c(com.tencent.mobileqq.widget.selectorview.a.this, qQStrangerRegisterProfileContentPart2, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.w
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQStrangerRegisterProfileContentPart.c.d(dialogInterface, i3);
                }
            });
            View view = QQStrangerRegisterProfileContentPart.this.constellationContainer;
            if (view == null) {
                return;
            }
            view.setClickable(true);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            View view = QQStrangerRegisterProfileContentPart.this.constellationContainer;
            if (view == null) {
                return;
            }
            view.setClickable(true);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(DialogInterface dialogInterface, int i3) {
    }
}
