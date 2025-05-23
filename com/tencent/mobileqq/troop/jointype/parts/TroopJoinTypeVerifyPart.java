package com.tencent.mobileqq.troop.jointype.parts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.jointype.TroopJoinTypeVM;
import com.tencent.mobileqq.troop.jointype.event.TroopAutoApprovalSettingUpdate;
import com.tencent.mobileqq.troop.jointype.event.TroopManageAutoApprovalEvent;
import com.tencent.mobileqq.troop.jointype.view.TroopJoinTypeFloatingView;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import h53.q;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001dB\u0007\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u001c\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030)0(H\u0016R,\u0010/\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0(j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\"\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\"\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00104R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u00104R\"\u0010?\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u00104R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u00104R\"\u0010C\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;0\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u00104R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\"\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u00104R\u0016\u0010I\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010ER\"\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u00104R\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010]\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/parts/TroopJoinTypeVerifyPart;", "Lcom/tencent/mobileqq/troop/jointype/parts/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "ma", "ua", "wa", "", "showAnswerInput", "Da", "ga", "", "configJoinType", "isSelected", LocaleUtils.L_JAPANESE, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$i;", DownloadInfo.spKey_Config, "ha", "configType", "Ca", "isAutoApprovalOpen", "Ea", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "C9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "verifyConfigs", "f", "Lcom/tencent/mobileqq/widget/listitem/Group;", "verifyJoinTypeGroup", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/x;", "needVerifyByMsgConfig", "i", "needVerifyByQuestionConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "needAnswerQuestionConfig", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", BdhLogUtil.LogTag.Tag_Conn, "autoVerifyConfig", "D", "questionConfig", "E", "correctQuestionConfig", UserInfo.SEX_FEMALE, "correctAnswerConfig", "G", "I", "selectedVerifyType", "H", "selectedVerifyTypeConfig", "oldSelectedVerifyType", "J", "oldSelectedVerifyTypeConfig", "Lcom/tencent/mobileqq/troop/jointype/view/TroopJoinTypeFloatingView;", "K", "Lcom/tencent/mobileqq/troop/jointype/view/TroopJoinTypeFloatingView;", "questionFloatingContainer", "L", "Landroid/view/View;", "headerView", "M", "contentView", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "N", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "questionInputView", "P", "answerInputView", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "headerLeftText", BdhLogUtil.LogTag.Tag_Req, "headerRightText", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopJoinTypeVerifyPart extends a implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> autoVerifyConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> questionConfig;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> correctQuestionConfig;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> correctAnswerConfig;

    /* renamed from: G, reason: from kotlin metadata */
    private int selectedVerifyType;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> selectedVerifyTypeConfig;

    /* renamed from: I, reason: from kotlin metadata */
    private int oldSelectedVerifyType;

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> oldSelectedVerifyTypeConfig;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TroopJoinTypeFloatingView questionFloatingContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View headerView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private QUISingleLineInputView questionInputView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private QUISingleLineInputView answerInputView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TextView headerLeftText;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TextView headerRightText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> verifyConfigs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group verifyJoinTypeGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> needVerifyByMsgConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> needVerifyByQuestionConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> needAnswerQuestionConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/parts/TroopJoinTypeVerifyPart$a;", "", "", "AUTO_APPROVE_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.jointype.parts.TroopJoinTypeVerifyPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/troop/jointype/parts/TroopJoinTypeVerifyPart$b", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements h53.q {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QUISingleLineInputView f297604e;

        b(QUISingleLineInputView qUISingleLineInputView) {
            this.f297604e = qUISingleLineInputView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeVerifyPart.this, (Object) qUISingleLineInputView);
            }
        }

        @Override // h53.q
        public void A4(@Nullable String title) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) title);
            }
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) s16);
            }
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // h53.k
        public void f8(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                q.a.a(this, z16);
            }
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            if (s16 == null || s16.length() == 0) {
                z16 = true;
            }
            if (z16) {
                TextView textView = TroopJoinTypeVerifyPart.this.headerRightText;
                if (textView != null) {
                    textView.setTextColor(this.f297604e.getResources().getColor(R.color.qui_common_text_secondary_02));
                    return;
                }
                return;
            }
            TextView textView2 = TroopJoinTypeVerifyPart.this.headerRightText;
            if (textView2 != null) {
                textView2.setTextColor(this.f297604e.getResources().getColor(R.color.qui_common_text_primary));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/jointype/parts/TroopJoinTypeVerifyPart$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeVerifyPart.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return TroopJoinTypeVerifyPart.this.contentView;
            }
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/jointype/parts/TroopJoinTypeVerifyPart$d", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements QUSBaseHalfScreenFloatingView.o {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3)).booleanValue();
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopJoinTypeVerifyPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.verifyConfigs = new ArrayList<>();
        this.verifyJoinTypeGroup = new Group(new com.tencent.mobileqq.widget.listitem.a[0]);
        this.selectedVerifyType = -1;
        this.oldSelectedVerifyType = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(final TroopJoinTypeVerifyPart this$0) {
        Editable editable;
        Editable editable2;
        Editable editable3;
        Editable editable4;
        EditText h16;
        EditText h17;
        Editable editable5;
        EditText h18;
        EditText h19;
        EditText h26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar = null;
        if (this$0.ga()) {
            final int i3 = this$0.selectedVerifyType;
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar2 = this$0.selectedVerifyTypeConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                xVar2 = null;
            }
            xVar2.O().e(null);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar3 = this$0.selectedVerifyTypeConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                xVar3 = null;
            }
            xVar3.O().f(false);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar4 = this$0.selectedVerifyTypeConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                xVar4 = null;
            }
            xVar4.O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.t
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    TroopJoinTypeVerifyPart.Ba(TroopJoinTypeVerifyPart.this, i3, view, z16);
                }
            });
            QUIListItemAdapter x95 = this$0.x9();
            if (x95 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar5 = this$0.selectedVerifyTypeConfig;
                if (xVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                    xVar5 = null;
                }
                x95.l0(xVar5);
            }
            int i16 = this$0.oldSelectedVerifyType;
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar6 = this$0.oldSelectedVerifyTypeConfig;
            if (xVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oldSelectedVerifyTypeConfig");
            } else {
                xVar = xVar6;
            }
            this$0.ha(i16, xVar);
            this$0.A9().Y2(this$0.selectedVerifyType);
            return;
        }
        TroopJoinTypeVM A9 = this$0.A9();
        QUISingleLineInputView qUISingleLineInputView = this$0.questionInputView;
        if (qUISingleLineInputView != null && (h26 = qUISingleLineInputView.h()) != null) {
            editable = h26.getText();
        } else {
            editable = null;
        }
        A9.Q2(String.valueOf(editable));
        TroopJoinTypeVM A92 = this$0.A9();
        QUISingleLineInputView qUISingleLineInputView2 = this$0.answerInputView;
        if (qUISingleLineInputView2 != null && (h19 = qUISingleLineInputView2.h()) != null) {
            editable2 = h19.getText();
        } else {
            editable2 = null;
        }
        A92.N2(String.valueOf(editable2));
        int i17 = this$0.selectedVerifyType;
        if (i17 == 5) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar7 = this$0.questionConfig;
            if (xVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questionConfig");
                xVar7 = null;
            }
            x.b.C8996b K = xVar7.K();
            QUISingleLineInputView qUISingleLineInputView3 = this$0.questionInputView;
            if (qUISingleLineInputView3 != null && (h18 = qUISingleLineInputView3.h()) != null) {
                editable5 = h18.getText();
            } else {
                editable5 = null;
            }
            K.b("\u95ee\u9898\uff1a" + ((Object) editable5));
            QUIListItemAdapter x96 = this$0.x9();
            if (x96 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar8 = this$0.questionConfig;
                if (xVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("questionConfig");
                } else {
                    xVar = xVar8;
                }
                x96.l0(xVar);
                return;
            }
            return;
        }
        if (i17 == 4) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar9 = this$0.correctQuestionConfig;
            if (xVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("correctQuestionConfig");
                xVar9 = null;
            }
            x.b.C8996b K2 = xVar9.K();
            QUISingleLineInputView qUISingleLineInputView4 = this$0.questionInputView;
            if (qUISingleLineInputView4 != null && (h17 = qUISingleLineInputView4.h()) != null) {
                editable3 = h17.getText();
            } else {
                editable3 = null;
            }
            K2.b("\u95ee\u9898\uff1a" + ((Object) editable3));
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar10 = this$0.correctAnswerConfig;
            if (xVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("correctAnswerConfig");
                xVar10 = null;
            }
            x.b.C8996b K3 = xVar10.K();
            QUISingleLineInputView qUISingleLineInputView5 = this$0.answerInputView;
            if (qUISingleLineInputView5 != null && (h16 = qUISingleLineInputView5.h()) != null) {
                editable4 = h16.getText();
            } else {
                editable4 = null;
            }
            K3.b("\u7b54\u6848\uff1a" + ((Object) editable4));
            QUIListItemAdapter x97 = this$0.x9();
            if (x97 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar11 = this$0.correctQuestionConfig;
                if (xVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("correctQuestionConfig");
                    xVar11 = null;
                }
                x97.l0(xVar11);
            }
            QUIListItemAdapter x98 = this$0.x9();
            if (x98 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar12 = this$0.correctAnswerConfig;
                if (xVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("correctAnswerConfig");
                } else {
                    xVar = xVar12;
                }
                x98.l0(xVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(TroopJoinTypeVerifyPart this$0, int i3, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.ja(i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca(int configType) {
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = null;
        if (configType != 2) {
            if (configType != 4) {
                if (configType == 5) {
                    QUIListItemAdapter x95 = x9();
                    if (x95 != null) {
                        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar2 = this.autoVerifyConfig;
                        if (xVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("autoVerifyConfig");
                            xVar2 = null;
                        }
                        x95.m0(xVar2, false);
                    }
                    QUIListItemAdapter x96 = x9();
                    if (x96 != null) {
                        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = this.questionConfig;
                        if (xVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("questionConfig");
                            xVar3 = null;
                        }
                        x96.m0(xVar3, true);
                    }
                    QUIListItemAdapter x97 = x9();
                    if (x97 != null) {
                        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar4 = this.correctQuestionConfig;
                        if (xVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("correctQuestionConfig");
                            xVar4 = null;
                        }
                        x97.m0(xVar4, false);
                    }
                    QUIListItemAdapter x98 = x9();
                    if (x98 != null) {
                        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar5 = this.correctAnswerConfig;
                        if (xVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("correctAnswerConfig");
                        } else {
                            xVar = xVar5;
                        }
                        x98.m0(xVar, false);
                        return;
                    }
                    return;
                }
                return;
            }
            QUIListItemAdapter x99 = x9();
            if (x99 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar6 = this.autoVerifyConfig;
                if (xVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("autoVerifyConfig");
                    xVar6 = null;
                }
                x99.m0(xVar6, false);
            }
            QUIListItemAdapter x910 = x9();
            if (x910 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar7 = this.questionConfig;
                if (xVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("questionConfig");
                    xVar7 = null;
                }
                x910.m0(xVar7, false);
            }
            QUIListItemAdapter x911 = x9();
            if (x911 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar8 = this.correctQuestionConfig;
                if (xVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("correctQuestionConfig");
                    xVar8 = null;
                }
                x911.m0(xVar8, true);
            }
            QUIListItemAdapter x912 = x9();
            if (x912 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar9 = this.correctAnswerConfig;
                if (xVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("correctAnswerConfig");
                } else {
                    xVar = xVar9;
                }
                x912.m0(xVar, true);
                return;
            }
            return;
        }
        QUIListItemAdapter x913 = x9();
        if (x913 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar10 = this.autoVerifyConfig;
            if (xVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoVerifyConfig");
                xVar10 = null;
            }
            x913.m0(xVar10, true);
        }
        QUIListItemAdapter x914 = x9();
        if (x914 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar11 = this.questionConfig;
            if (xVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("questionConfig");
                xVar11 = null;
            }
            x914.m0(xVar11, false);
        }
        QUIListItemAdapter x915 = x9();
        if (x915 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar12 = this.correctQuestionConfig;
            if (xVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("correctQuestionConfig");
                xVar12 = null;
            }
            x915.m0(xVar12, false);
        }
        QUIListItemAdapter x916 = x9();
        if (x916 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar13 = this.correctAnswerConfig;
            if (xVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("correctAnswerConfig");
            } else {
                xVar = xVar13;
            }
            x916.m0(xVar, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Da(boolean showAnswerInput) {
        boolean z16;
        boolean z17;
        QUISingleLineInputView qUISingleLineInputView;
        TroopInfo k26;
        String str;
        String str2;
        boolean z18;
        QUISingleLineInputView qUISingleLineInputView2;
        boolean z19 = true;
        if (A9().e2().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QUISingleLineInputView qUISingleLineInputView3 = this.questionInputView;
            if (qUISingleLineInputView3 != null) {
                qUISingleLineInputView3.setContentText(A9().e2());
            }
        } else {
            TroopInfo k27 = A9().k2();
            if (k27 != null && (str2 = k27.joinTroopQuestion) != null) {
                if (str2.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z17 = true;
                    if (z17 && (qUISingleLineInputView = this.questionInputView) != null) {
                        k26 = A9().k2();
                        if (k26 == null) {
                            str = k26.joinTroopQuestion;
                        } else {
                            str = null;
                        }
                        qUISingleLineInputView.setContentText(str);
                    }
                }
            }
            z17 = false;
            if (z17) {
                k26 = A9().k2();
                if (k26 == null) {
                }
                qUISingleLineInputView.setContentText(str);
            }
        }
        if (showAnswerInput) {
            QUISingleLineInputView qUISingleLineInputView4 = this.answerInputView;
            if (qUISingleLineInputView4 != null) {
                qUISingleLineInputView4.setVisibility(0);
            }
            if (A9().a2().length() <= 0) {
                z19 = false;
            }
            if (z19 && (qUISingleLineInputView2 = this.answerInputView) != null) {
                qUISingleLineInputView2.setContentText(A9().a2());
            }
        } else {
            QUISingleLineInputView qUISingleLineInputView5 = this.answerInputView;
            if (qUISingleLineInputView5 != null) {
                qUISingleLineInputView5.setVisibility(8);
            }
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView != null) {
            troopJoinTypeFloatingView.measure(View.MeasureSpec.makeMeasureSpec(troopJoinTypeFloatingView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(troopJoinTypeFloatingView.getMeasuredHeight(), 1073741824));
            troopJoinTypeFloatingView.layout(0, 0, troopJoinTypeFloatingView.getMeasuredWidth(), troopJoinTypeFloatingView.getMeasuredHeight());
            troopJoinTypeFloatingView.P(0);
        }
        QUISingleLineInputView qUISingleLineInputView6 = this.questionInputView;
        if (qUISingleLineInputView6 != null) {
            qUISingleLineInputView6.setEditTextRequestFocused();
        }
    }

    private final void Ea(boolean isAutoApprovalOpen) {
        String str;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = this.autoVerifyConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoVerifyConfig");
            xVar = null;
        }
        x.c.g O = xVar.O();
        if (isAutoApprovalOpen) {
            str = "\u5df2\u5f00\u542f";
        } else {
            str = "\u672a\u5f00\u542f";
        }
        O.h(str);
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = this.autoVerifyConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autoVerifyConfig");
            } else {
                xVar2 = xVar3;
            }
            x95.l0(xVar2);
        }
    }

    private final boolean ga() {
        Editable editable;
        EditText h16;
        EditText h17;
        EditText h18;
        int i3 = this.selectedVerifyType;
        Editable editable2 = null;
        if (i3 == 5) {
            QUISingleLineInputView qUISingleLineInputView = this.questionInputView;
            if (qUISingleLineInputView != null && (h18 = qUISingleLineInputView.h()) != null) {
                editable2 = h18.getText();
            }
            return TextUtils.isEmpty(editable2);
        }
        if (i3 != 4) {
            return false;
        }
        QUISingleLineInputView qUISingleLineInputView2 = this.questionInputView;
        if (qUISingleLineInputView2 != null && (h17 = qUISingleLineInputView2.h()) != null) {
            editable = h17.getText();
        } else {
            editable = null;
        }
        if (!TextUtils.isEmpty(editable)) {
            QUISingleLineInputView qUISingleLineInputView3 = this.answerInputView;
            if (qUISingleLineInputView3 != null && (h16 = qUISingleLineInputView3.h()) != null) {
                editable2 = h16.getText();
            }
            if (!TextUtils.isEmpty(editable2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(final int configJoinType, com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> config) {
        this.selectedVerifyType = this.oldSelectedVerifyType;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar = this.oldSelectedVerifyTypeConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldSelectedVerifyTypeConfig");
            xVar = null;
        }
        this.selectedVerifyTypeConfig = xVar;
        config.O().e(null);
        config.O().f(true);
        config.O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.r
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                TroopJoinTypeVerifyPart.ia(TroopJoinTypeVerifyPart.this, configJoinType, view, z16);
            }
        });
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            x95.l0(config);
        }
        Ca(configJoinType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(TroopJoinTypeVerifyPart this$0, int i3, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.ja(i3, z16);
    }

    private final void ja(int configJoinType, boolean isSelected) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar = null;
        if (isSelected) {
            this.oldSelectedVerifyType = this.selectedVerifyType;
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar2 = this.selectedVerifyTypeConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                xVar2 = null;
            }
            this.oldSelectedVerifyTypeConfig = xVar2;
            if (configJoinType != 4) {
                if (configJoinType == 5) {
                    Da(false);
                }
            } else {
                Da(true);
            }
            final int i3 = this.selectedVerifyType;
            if (i3 == configJoinType) {
                return;
            }
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar3 = this.selectedVerifyTypeConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                xVar3 = null;
            }
            xVar3.O().e(null);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar4 = this.selectedVerifyTypeConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                xVar4 = null;
            }
            xVar4.O().f(false);
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar5 = this.selectedVerifyTypeConfig;
            if (xVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                xVar5 = null;
            }
            xVar5.O().e(new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.s
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    TroopJoinTypeVerifyPart.la(TroopJoinTypeVerifyPart.this, i3, view, z16);
                }
            });
            QUIListItemAdapter x95 = x9();
            if (x95 != null) {
                com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar6 = this.selectedVerifyTypeConfig;
                if (xVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                } else {
                    xVar = xVar6;
                }
                x95.l0(xVar);
            }
            Ca(configJoinType);
            this.selectedVerifyType = configJoinType;
            A9().Y2(this.selectedVerifyType);
            return;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar7 = this.selectedVerifyTypeConfig;
        if (xVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
        } else {
            xVar = xVar7;
        }
        ha(configJoinType, xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(TroopJoinTypeVerifyPart this$0, int i3, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.ja(i3, z16);
    }

    private final void ma() {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        boolean z19;
        String str2;
        boolean z26;
        boolean z27;
        String str3;
        boolean z28;
        String str4;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar;
        x.b.d dVar = new x.b.d("\u9700\u8981\u53d1\u9001\u9a8c\u8bc1\u6d88\u606f");
        boolean z29 = true;
        if (this.selectedVerifyType == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.i(z16, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.x
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z36) {
                TroopJoinTypeVerifyPart.na(TroopJoinTypeVerifyPart.this, view, z36);
            }
        }));
        this.needVerifyByMsgConfig = xVar2;
        this.verifyConfigs.add(xVar2);
        x.b.C8996b c8996b = new x.b.C8996b("\u52a0\u7fa4\u81ea\u52a8\u5ba1\u6279", R.drawable.qui_list_symbol);
        TroopInfo k26 = A9().k2();
        if (k26 != null && k26.isAutoApprovalOpen()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            str = "\u5df2\u5f00\u542f";
        } else {
            str = "\u672a\u5f00\u542f";
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = new com.tencent.mobileqq.widget.listitem.x<>(c8996b, new x.c.g(str, true, false, 4, null));
        if (this.selectedVerifyType == 2) {
            z18 = true;
        } else {
            z18 = false;
        }
        xVar3.p(z18);
        xVar3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopJoinTypeVerifyPart.pa(TroopJoinTypeVerifyPart.this, view);
            }
        });
        this.autoVerifyConfig = xVar3;
        x.b.d dVar2 = new x.b.d("\u56de\u7b54\u95ee\u9898\u5e76\u7531\u7ba1\u7406\u5458\u5ba1\u6838");
        if (this.selectedVerifyType == 5) {
            z19 = true;
        } else {
            z19 = false;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar4 = new com.tencent.mobileqq.widget.listitem.x<>(dVar2, new x.c.i(z19, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.z
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z36) {
                TroopJoinTypeVerifyPart.qa(TroopJoinTypeVerifyPart.this, view, z36);
            }
        }));
        this.needVerifyByQuestionConfig = xVar4;
        this.verifyConfigs.add(xVar4);
        TroopInfo k27 = A9().k2();
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar5 = null;
        if (k27 != null) {
            str2 = k27.joinTroopQuestion;
        } else {
            str2 = null;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar6 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.C8996b("\u95ee\u9898\uff1a" + str2, R.drawable.qui_list_symbol), new x.c.g("", true, false, 4, null));
        if (this.selectedVerifyType == 5) {
            z26 = true;
        } else {
            z26 = false;
        }
        xVar6.p(z26);
        xVar6.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopJoinTypeVerifyPart.ra(TroopJoinTypeVerifyPart.this, view);
            }
        });
        this.questionConfig = xVar6;
        this.verifyConfigs.add(xVar6);
        x.b.d dVar3 = new x.b.d("\u6b63\u786e\u56de\u7b54\u95ee\u9898");
        if (this.selectedVerifyType == 4) {
            z27 = true;
        } else {
            z27 = false;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.i> xVar7 = new com.tencent.mobileqq.widget.listitem.x<>(dVar3, new x.c.i(z27, new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.mobileqq.troop.jointype.parts.ab
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z36) {
                TroopJoinTypeVerifyPart.sa(TroopJoinTypeVerifyPart.this, view, z36);
            }
        }));
        this.needAnswerQuestionConfig = xVar7;
        this.verifyConfigs.add(xVar7);
        TroopInfo k28 = A9().k2();
        if (k28 != null) {
            str3 = k28.joinTroopQuestion;
        } else {
            str3 = null;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar8 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.C8996b("\u95ee\u9898\uff1a" + str3, R.drawable.qui_list_symbol), new x.c.g("", true, false, 4, null));
        if (this.selectedVerifyType == 4) {
            z28 = true;
        } else {
            z28 = false;
        }
        xVar8.p(z28);
        xVar8.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopJoinTypeVerifyPart.ta(TroopJoinTypeVerifyPart.this, view);
            }
        });
        this.correctQuestionConfig = xVar8;
        TroopInfo k29 = A9().k2();
        if (k29 != null) {
            str4 = k29.joinTroopAnswer;
        } else {
            str4 = null;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar9 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.C8996b("\u7b54\u6848\uff1a" + str4, R.drawable.qui_list_symbol), new x.c.g("", true, false, 4, null));
        if (this.selectedVerifyType != 4) {
            z29 = false;
        }
        xVar9.p(z29);
        xVar9.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopJoinTypeVerifyPart.oa(TroopJoinTypeVerifyPart.this, view);
            }
        });
        this.correctAnswerConfig = xVar9;
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList = this.verifyConfigs;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar10 = this.correctQuestionConfig;
        if (xVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("correctQuestionConfig");
            xVar10 = null;
        }
        arrayList.add(xVar10);
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList2 = this.verifyConfigs;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar11 = this.correctAnswerConfig;
        if (xVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("correctAnswerConfig");
            xVar11 = null;
        }
        arrayList2.add(xVar11);
        Object[] array = this.verifyConfigs.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        this.verifyJoinTypeGroup = new Group("\u8eab\u4efd\u9a8c\u8bc1\u65b9\u5f0f", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        int i3 = this.selectedVerifyType;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 5) {
                    xVar = this.needVerifyByMsgConfig;
                    if (xVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("needVerifyByMsgConfig");
                        xVar = null;
                    }
                } else {
                    xVar = this.needVerifyByQuestionConfig;
                    if (xVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("needVerifyByQuestionConfig");
                        xVar = null;
                    }
                }
            } else {
                xVar = this.needAnswerQuestionConfig;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("needAnswerQuestionConfig");
                    xVar = null;
                }
            }
        } else {
            xVar = this.needVerifyByMsgConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("needVerifyByMsgConfig");
                xVar = null;
            }
        }
        this.selectedVerifyTypeConfig = xVar;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
        } else {
            xVar5 = xVar;
        }
        this.oldSelectedVerifyTypeConfig = xVar5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(TroopJoinTypeVerifyPart this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.ja(2, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(TroopJoinTypeVerifyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Da(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(TroopJoinTypeVerifyPart this$0, View view) {
        String str;
        String replace$default;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopInfo k26 = this$0.A9().k2();
        if (k26 != null) {
            str = k26.getTroopUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        replace$default = StringsKt__StringsJVMKt.replace$default("https://qun.qq.com/qqweb/m/qun/qun_robot/auto-approval.html?_wv=1027&gc=$GCODE$&page=groupSetting", "$GCODE$", str, false, 4, (Object) null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", replace$default);
        this$0.getActivity().startActivity(intent);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(TroopJoinTypeVerifyPart this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.ja(5, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(TroopJoinTypeVerifyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Da(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(TroopJoinTypeVerifyPart this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.ja(4, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(TroopJoinTypeVerifyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Da(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ua() {
        LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
        if (a16 != null) {
            LiveData<Integer> d26 = A9().d2();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.jointype.parts.TroopJoinTypeVerifyPart$initObserver$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeVerifyPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    Group group;
                    com.tencent.mobileqq.widget.listitem.x xVar;
                    Group group2;
                    com.tencent.mobileqq.widget.listitem.x xVar2;
                    Group group3;
                    com.tencent.mobileqq.widget.listitem.x xVar3;
                    int i3;
                    com.tencent.mobileqq.widget.listitem.x xVar4;
                    com.tencent.mobileqq.widget.listitem.x xVar5;
                    Group group4;
                    int i16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                        return;
                    }
                    if (num != null && num.intValue() == -1) {
                        i16 = TroopJoinTypeVerifyPart.this.selectedVerifyType;
                        if (num.intValue() == i16) {
                            return;
                        }
                    }
                    com.tencent.mobileqq.widget.listitem.x xVar6 = null;
                    if (num != null && num.intValue() == 2) {
                        QUIListItemAdapter x95 = TroopJoinTypeVerifyPart.this.x9();
                        if (x95 != null) {
                            group4 = TroopJoinTypeVerifyPart.this.verifyJoinTypeGroup;
                            x95.n0(group4, true);
                        }
                        TroopJoinTypeVerifyPart troopJoinTypeVerifyPart = TroopJoinTypeVerifyPart.this;
                        xVar3 = troopJoinTypeVerifyPart.needVerifyByMsgConfig;
                        if (xVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("needVerifyByMsgConfig");
                            xVar3 = null;
                        }
                        troopJoinTypeVerifyPart.selectedVerifyTypeConfig = xVar3;
                        TroopJoinTypeVerifyPart.this.selectedVerifyType = 2;
                        TroopJoinTypeVerifyPart troopJoinTypeVerifyPart2 = TroopJoinTypeVerifyPart.this;
                        i3 = troopJoinTypeVerifyPart2.selectedVerifyType;
                        troopJoinTypeVerifyPart2.oldSelectedVerifyType = i3;
                        TroopJoinTypeVerifyPart troopJoinTypeVerifyPart3 = TroopJoinTypeVerifyPart.this;
                        xVar4 = troopJoinTypeVerifyPart3.selectedVerifyTypeConfig;
                        if (xVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                            xVar4 = null;
                        }
                        troopJoinTypeVerifyPart3.oldSelectedVerifyTypeConfig = xVar4;
                        TroopJoinTypeVerifyPart troopJoinTypeVerifyPart4 = TroopJoinTypeVerifyPart.this;
                        xVar5 = troopJoinTypeVerifyPart4.selectedVerifyTypeConfig;
                        if (xVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("selectedVerifyTypeConfig");
                        } else {
                            xVar6 = xVar5;
                        }
                        troopJoinTypeVerifyPart4.ha(2, xVar6);
                        TroopJoinTypeVerifyPart.this.Ca(2);
                        return;
                    }
                    if (num != null && num.intValue() == 5) {
                        QUIListItemAdapter x96 = TroopJoinTypeVerifyPart.this.x9();
                        if (x96 != null) {
                            group3 = TroopJoinTypeVerifyPart.this.verifyJoinTypeGroup;
                            x96.n0(group3, true);
                        }
                        TroopJoinTypeVerifyPart troopJoinTypeVerifyPart5 = TroopJoinTypeVerifyPart.this;
                        xVar2 = troopJoinTypeVerifyPart5.needVerifyByQuestionConfig;
                        if (xVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("needVerifyByQuestionConfig");
                        } else {
                            xVar6 = xVar2;
                        }
                        troopJoinTypeVerifyPart5.selectedVerifyTypeConfig = xVar6;
                        TroopJoinTypeVerifyPart.this.Ca(5);
                        return;
                    }
                    if (num != null && num.intValue() == 4) {
                        QUIListItemAdapter x97 = TroopJoinTypeVerifyPart.this.x9();
                        if (x97 != null) {
                            group2 = TroopJoinTypeVerifyPart.this.verifyJoinTypeGroup;
                            x97.n0(group2, true);
                        }
                        TroopJoinTypeVerifyPart troopJoinTypeVerifyPart6 = TroopJoinTypeVerifyPart.this;
                        xVar = troopJoinTypeVerifyPart6.needAnswerQuestionConfig;
                        if (xVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("needAnswerQuestionConfig");
                        } else {
                            xVar6 = xVar;
                        }
                        troopJoinTypeVerifyPart6.selectedVerifyTypeConfig = xVar6;
                        TroopJoinTypeVerifyPart.this.Ca(4);
                        return;
                    }
                    QUIListItemAdapter x98 = TroopJoinTypeVerifyPart.this.x9();
                    if (x98 != null) {
                        group = TroopJoinTypeVerifyPart.this.verifyJoinTypeGroup;
                        x98.n0(group, false);
                    }
                }
            };
            d26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.jointype.parts.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopJoinTypeVerifyPart.va(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wa() {
        TextView textView;
        TextView textView2;
        QUISingleLineInputView qUISingleLineInputView;
        this.questionFloatingContainer = (TroopJoinTypeFloatingView) getPartRootView().findViewById(R.id.vb7);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g0q, (ViewGroup) this.questionFloatingContainer, false);
        this.headerView = inflate;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (inflate != null && (textView = (TextView) inflate.findViewById(R.id.x8m)) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopJoinTypeVerifyPart.xa(TroopJoinTypeVerifyPart.this, view);
                }
            });
        } else {
            textView = null;
        }
        this.headerLeftText = textView;
        View view = this.headerView;
        if (view != null && (textView2 = (TextView) view.findViewById(R.id.x8q)) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopJoinTypeVerifyPart.za(TroopJoinTypeVerifyPart.this, view2);
                }
            });
        } else {
            textView2 = null;
        }
        this.headerRightText = textView2;
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.g0o, (ViewGroup) this.questionFloatingContainer, false);
        this.contentView = inflate2;
        if (inflate2 != null && (qUISingleLineInputView = (QUISingleLineInputView) inflate2.findViewById(R.id.f102435xw)) != null) {
            qUISingleLineInputView.setInputViewWatcher(new b(qUISingleLineInputView));
        } else {
            qUISingleLineInputView = null;
        }
        this.questionInputView = qUISingleLineInputView;
        View view2 = this.contentView;
        if (view2 != null) {
            qUISingleLineInputView2 = (QUISingleLineInputView) view2.findViewById(R.id.f102425xv);
        }
        this.answerInputView = qUISingleLineInputView2;
        if (qUISingleLineInputView2 != null) {
            qUISingleLineInputView2.setVisibility(8);
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView != null) {
            troopJoinTypeFloatingView.setHeaderView(this.headerView);
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView2 = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView2 != null) {
            troopJoinTypeFloatingView2.setQUSDragFloatController(new c());
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView3 = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView3 != null) {
            troopJoinTypeFloatingView3.setOnOutsideAreaClickListener(new d());
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView4 = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView4 != null) {
            troopJoinTypeFloatingView4.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.troop.jointype.parts.v
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    TroopJoinTypeVerifyPart.Aa(TroopJoinTypeVerifyPart.this);
                }
            });
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView5 = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView5 != null) {
            troopJoinTypeFloatingView5.setDraggable(false);
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView6 = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView6 != null) {
            troopJoinTypeFloatingView6.setIsHeightWrapContent(true);
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView7 = this.questionFloatingContainer;
        if (troopJoinTypeFloatingView7 != null) {
            troopJoinTypeFloatingView7.setEnableParentDisallowInterruptTouchEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(TroopJoinTypeVerifyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.questionInputView;
        if (qUISingleLineInputView != null) {
            qUISingleLineInputView.setContentText("");
        }
        QUISingleLineInputView qUISingleLineInputView2 = this$0.answerInputView;
        if (qUISingleLineInputView2 != null) {
            qUISingleLineInputView2.setContentText("");
        }
        TroopJoinTypeFloatingView troopJoinTypeFloatingView = this$0.questionFloatingContainer;
        if (troopJoinTypeFloatingView != null) {
            troopJoinTypeFloatingView.t();
        }
        InputMethodUtil.hide(this$0.getActivity());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        if (r3 != true) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void za(TroopJoinTypeVerifyPart this$0, View view) {
        boolean z16;
        QUISingleLineInputView qUISingleLineInputView;
        int i3;
        TroopJoinTypeFloatingView troopJoinTypeFloatingView;
        EditText h16;
        Editable text;
        boolean z17;
        EditText h17;
        Editable text2;
        boolean z18;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView2 = this$0.questionInputView;
        boolean z19 = true;
        if (qUISingleLineInputView2 != null && (h17 = qUISingleLineInputView2.h()) != null && (text2 = h17.getText()) != null) {
            if (text2.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z16 = true;
                qUISingleLineInputView = this$0.answerInputView;
                if (qUISingleLineInputView != null && (h16 = qUISingleLineInputView.h()) != null && (text = h16.getText()) != null) {
                    if (text.length() <= 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z19 = false;
                if (z16 && ((i3 = this$0.selectedVerifyType) == 5 || (i3 == 4 && z19))) {
                    troopJoinTypeFloatingView = this$0.questionFloatingContainer;
                    if (troopJoinTypeFloatingView != null) {
                        troopJoinTypeFloatingView.t();
                    }
                    InputMethodUtil.hide(this$0.getActivity());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        z16 = false;
        qUISingleLineInputView = this$0.answerInputView;
        if (qUISingleLineInputView != null) {
            if (text.length() <= 0) {
            }
        }
        z19 = false;
        if (z16) {
            troopJoinTypeFloatingView = this$0.questionFloatingContainer;
            if (troopJoinTypeFloatingView != null) {
            }
            InputMethodUtil.hide(this$0.getActivity());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.troop.jointype.parts.a
    @NotNull
    public Group[] C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Group[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new Group[]{this.verifyJoinTypeGroup};
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopManageAutoApprovalEvent.class, TroopAutoApprovalSettingUpdate.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        int h26 = A9().h2();
        this.selectedVerifyType = h26;
        this.oldSelectedVerifyType = h26;
        ma();
        ua();
        wa();
    }

    @Override // com.tencent.mobileqq.troop.jointype.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopJoinTypeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopJoinTypeVM::class.java)");
        B9((TroopJoinTypeVM) viewModel);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else if (event instanceof TroopManageAutoApprovalEvent) {
            Ea(((TroopManageAutoApprovalEvent) event).isAutoApprovalOpen());
        } else if (event instanceof TroopAutoApprovalSettingUpdate) {
            Ea(((TroopAutoApprovalSettingUpdate) event).getAutoApprovalSetting());
        }
    }
}
