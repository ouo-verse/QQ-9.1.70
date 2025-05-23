package com.tencent.mobileqq.gamecenter.qa.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.util.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0002>^B#\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010[\u001a\u00020U\u00a2\u0006\u0004\b\\\u0010]J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0002J$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J>\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J2\u0010&\u001a\u0004\u0018\u00010%2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010$\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010(\u001a\u00020\u0000J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u001a\u0010*\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\"\u00101\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010\u000fJ\u000e\u00103\u001a\u00020\u00052\u0006\u0010$\u001a\u000202J\b\u00104\u001a\u0004\u0018\u000102J\u0010\u00105\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J6\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001cJ\u0010\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u0004\u0018\u00010\u000fJ\b\u0010@\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010A\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u0010C\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u001cR\u001e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010AR\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010NR\u0016\u0010P\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010AR\u0018\u0010R\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", "Landroid/text/style/ClickableSpan;", "Lcom/tencent/mobileqq/gamecenter/qa/view/a;", "Landroid/widget/EditText;", "editText", "", tl.h.F, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/text/SpannableString;", "spannableStr", "v", "spanStr", "t", "Landroid/view/View;", "view", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/app/Activity;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/utils/dialogutils/a;", "menu", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/widget/BubblePopupWindow$OnDismissListener;", "onDismissListener", "", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/widget/BubblePopupWindow;", "E", "popup", "Landroid/content/Context;", "ctx", "listener", "Lcom/tencent/mobileqq/utils/dialogutils/QQCustomMenuNoIconLayout;", "k", "u", "j", "i", DomainData.DOMAIN_NAME, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "cardData", "userInputTitle", "B", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "D", "p", NodeProps.ON_CLICK, "rawX", "rawY", "lineTop", "lineBottom", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "Landroid/text/TextPaint;", "ds", "updateDrawState", "a", "r", "o", "I", "index", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "mEditTextViewRef", "e", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "mListener", "f", "mPopX", "Lcom/tencent/mobileqq/gamecenter/qa/view/w;", "Lcom/tencent/mobileqq/gamecenter/qa/view/w;", "mLinkCardSpan", "mPopY", "Ljava/lang/String;", "mLink", BdhLogUtil.LogTag.Tag_Conn, "mTitle", "", "Z", "mEnableLinkCard", "Landroid/text/TextWatcher;", "Landroid/text/TextWatcher;", "mTextWatcher", "enableLinkCard", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ab extends ClickableSpan implements a {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String mTitle;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mEnableLinkCard;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextWatcher mTextWatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<EditText> mEditTextViewRef = new WeakReference<>(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mPopX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private w mLinkCardSpan;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mPopY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mLink;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/ab$a;", "", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "", "enableLinkCard", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", "a", "LINK", "Ljava/lang/String;", "", "LINK_CLICK_GAP", "I", "LOCATION_SIZE", "RANDOM_SIGN", "SPAN_MINI_LENGTH", "TAG", "", "UPDATE_DELAY", "J", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.view.ab$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ab a(@Nullable String link, @Nullable String title, boolean enableLinkCard) {
            return new ab(link, title, enableLinkCard);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "", "", "type", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "", "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void a(int type, @Nullable String link, @Nullable String title);

        void b(@Nullable String link);
    }

    public ab(@Nullable String str, @Nullable String str2, boolean z16) {
        this.mLink = str;
        this.mTitle = str2;
        this.mEnableLinkCard = z16;
    }

    private final void A(EditText editText) {
        TextWatcher textWatcher = this.mTextWatcher;
        if (textWatcher != null && editText != null) {
            editText.removeTextChangedListener(textWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(com.tencent.mobileqq.gamecenter.qa.util.d producer, Activity activity, GameQALinkCardData gameQALinkCardData, String str) {
        Intrinsics.checkNotNullParameter(producer, "$producer");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        producer.m(activity, gameQALinkCardData, str);
    }

    private final BubblePopupWindow E(View view, com.tencent.mobileqq.utils.dialogutils.a menu, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener, int x16, int y16) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(k(bubblePopupWindow, view.getContext(), menu, onClickListener));
        bubblePopupWindow.setOnDismissListener(onDismissListener);
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(false);
        bubblePopupWindow.showAtLocation(view, x16, y16);
        return bubblePopupWindow;
    }

    private final void F(final View view, final String link, final String title) {
        com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
        aVar.a(R.id.vk8, BaseApplication.getContext().getString(R.string.f1370705v));
        aVar.a(R.id.vk7, BaseApplication.getContext().getString(R.string.f1370505t));
        aVar.a(R.id.vkb, BaseApplication.getContext().getString(R.string.f13713061));
        if (this.mEnableLinkCard && GameQAUtil.q(link)) {
            aVar.a(R.id.vk_, BaseApplication.getContext().getString(R.string.f1370905x));
        }
        E(view, aVar, new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ab.G(ab.this, link, title, view2);
            }
        }, new BubblePopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.aa
            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public final void onDismiss() {
                ab.H(view);
            }
        }, this.mPopX, this.mPopY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ab this$0, String str, String str2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int id5 = view.getId();
        if (id5 == R.id.vk8) {
            b bVar = this$0.mListener;
            if (bVar != null) {
                bVar.a(1, str, str2);
            }
        } else if (id5 == R.id.vk7) {
            b bVar2 = this$0.mListener;
            if (bVar2 != null) {
                bVar2.b(str);
            }
        } else if (id5 == R.id.vkb) {
            this$0.z();
        } else if (id5 == R.id.vk_) {
            EditText editText = this$0.mEditTextViewRef.get();
            Intrinsics.checkNotNull(editText, "null cannot be cast to non-null type android.view.View");
            Activity s16 = this$0.s(editText);
            if (s16 != null) {
                this$0.B(s16, null, this$0.mTitle);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.setSelected(false);
    }

    private final void h(EditText editText) {
        com.tencent.mobileqq.gamecenter.qa.view.b bVar = new com.tencent.mobileqq.gamecenter.qa.view.b();
        this.mTextWatcher = bVar;
        if (editText != null) {
            editText.addTextChangedListener(bVar);
        }
    }

    private final QQCustomMenuNoIconLayout k(BubblePopupWindow popup, Context ctx, com.tencent.mobileqq.utils.dialogutils.a menu, View.OnClickListener listener) {
        if (popup != null) {
            popup.setFocusable(false);
        }
        QQCustomMenuItemPriorityHelper.d(menu);
        QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(ctx);
        qQCustomMenuNoIconLayout.setGravity(17);
        qQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuNoIconLayout.setPopupWindow(popup, null);
        qQCustomMenuNoIconLayout.setMenu(menu);
        qQCustomMenuNoIconLayout.setMenuIconClickListener(listener);
        qQCustomMenuNoIconLayout.D();
        return qQCustomMenuNoIconLayout;
    }

    @JvmStatic
    @NotNull
    public static final ab l(@Nullable String str, @Nullable String str2, boolean z16) {
        return INSTANCE.a(str, str2, z16);
    }

    private final Activity s(View view) {
        Context context = null;
        if (view != null) {
            Context context2 = view.getContext();
            if (!(context2 instanceof Activity)) {
                if (context2 instanceof ContextThemeWrapper) {
                    ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context2;
                    if (contextThemeWrapper.getBaseContext() instanceof Activity) {
                        Context baseContext = contextThemeWrapper.getBaseContext();
                        Intrinsics.checkNotNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
                        context2 = (Activity) baseContext;
                    }
                }
            }
            context = context2;
        }
        return (Activity) context;
    }

    private final void t(SpannableString spanStr) {
        spanStr.setSpan(this, 0, spanStr.length(), 33);
    }

    private final void u(EditText editText) {
        editText.setMovementMethod(LinkMovementMethod.getInstance());
        h(editText);
    }

    private final void v(EditText editText, SpannableString spannableStr) {
        Editable editableText = editText.getEditableText();
        int selectionStart = editText.getSelectionStart();
        if (selectionStart >= 0 && selectionStart < editableText.length()) {
            editableText.insert(selectionStart, spannableStr);
            editText.setText(editableText);
            editText.setSelection(selectionStart + spannableStr.length());
        } else {
            editableText.append((CharSequence) spannableStr);
            editText.setText(editableText);
            editText.setSelection(editableText.length());
        }
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ab this$0, EditText editText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A(editText);
    }

    private final void z() {
        EditText editText;
        WeakReference<EditText> weakReference = this.mEditTextViewRef;
        if (weakReference != null) {
            editText = weakReference.get();
        } else {
            editText = null;
        }
        if (editText != null) {
            editText.getEditableText().removeSpan(this);
        }
    }

    public final void B(@NotNull final Activity activity, @Nullable final GameQALinkCardData cardData, @Nullable final String userInputTitle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (TextUtils.isEmpty(this.mLink)) {
            return;
        }
        String str = this.mLink;
        Intrinsics.checkNotNull(str);
        final com.tencent.mobileqq.gamecenter.qa.util.d dVar = new com.tencent.mobileqq.gamecenter.qa.util.d(str);
        dVar.r(new c());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.x
            @Override // java.lang.Runnable
            public final void run() {
                ab.C(com.tencent.mobileqq.gamecenter.qa.util.d.this, activity, cardData, userInputTitle);
            }
        });
    }

    public final void D(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    @NotNull
    public final ab I(@Nullable EditText editText) {
        if (editText == null) {
            return this;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GameStrategyLinkSpan", 1, "[updateFromDraft]");
        }
        this.mEditTextViewRef = new WeakReference<>(editText);
        u(editText);
        return this;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.view.a
    public void a() {
        final EditText editText = this.mEditTextViewRef.get();
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.y
                @Override // java.lang.Runnable
                public final void run() {
                    ab.y(ab.this, editText);
                }
            });
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void i(@NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.mEditTextViewRef = new WeakReference<>(editText);
        SpannableString spannableString = new SpannableString(n(this.mTitle, this.mLink));
        t(spannableString);
        v(editText, spannableString);
        u(editText);
    }

    @NotNull
    public final ab j() {
        ab a16 = INSTANCE.a(this.mLink, this.mTitle, this.mEnableLinkCard);
        a16.mEditTextViewRef = new WeakReference<>(this.mEditTextViewRef.get());
        EditText editText = this.mEditTextViewRef.get();
        if (editText != null) {
            a16.u(editText);
        }
        return a16;
    }

    public final void m() {
        w wVar = this.mLinkCardSpan;
        if (wVar != null) {
            GameQAUtil.c(wVar, this.mEditTextViewRef.get());
        } else {
            GameQAUtil.d(this, this.mEditTextViewRef.get());
        }
    }

    @NotNull
    public final String n(@Nullable String title, @Nullable String link) {
        return com.tencent.mobileqq.gamecenter.qa.manager.b.INSTANCE.a(title, link);
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final String getMLink() {
        return this.mLink;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final b getMListener() {
        return this.mListener;
    }

    @NotNull
    public final String q(int index) {
        String encode;
        String str = "";
        if (TextUtils.isEmpty(this.mLink)) {
            encode = "";
        } else {
            encode = URLEncoder.encode(this.mLink, "UTF-8");
        }
        if (!TextUtils.isEmpty(this.mTitle)) {
            str = URLEncoder.encode(this.mTitle, "UTF-8");
        }
        return "{{link:" + encode + "|" + str + "|" + index + "}}";
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getMTitle() {
        return this.mTitle;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds5) {
        Intrinsics.checkNotNullParameter(ds5, "ds");
        ds5.setUnderlineText(false);
        ds5.clearShadowLayer();
        ds5.setColor(BaseApplication.context.getResources().getColor(R.color.cf7));
    }

    public final void w() {
        b bVar = this.mListener;
        if (bVar != null) {
            bVar.a(2, getMLink(), getMTitle());
        }
    }

    public final void x(@NotNull View view, int rawX, int rawY, int lineTop, int lineBottom, int off) {
        Intrinsics.checkNotNullParameter(view, "view");
        EditText editText = this.mEditTextViewRef.get();
        if (editText == null) {
            return;
        }
        int spanEnd = editText.getEditableText().getSpanEnd(this);
        int spanStart = editText.getEditableText().getSpanStart(this);
        if (spanStart + 1 <= off && off <= spanEnd - 1) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mPopX = rawX;
            this.mPopY = iArr[1] + lineTop;
            F(editText, this.mLink, this.mTitle);
        }
        QLog.i("GameStrategyLinkSpan", 2, "rawX:" + rawX + ",rawY:" + rawY + ",lineTop:" + lineTop + ",lineBottom:" + lineBottom + ",off:" + off + ",spanStart:" + spanStart + ",spanEnd:" + spanEnd);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/view/ab$c", "Lcom/tencent/mobileqq/gamecenter/qa/util/d$c;", "", "onLoading", "Landroid/graphics/Bitmap;", "cardBitmap", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "data", "a", "onLoadFailed", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements d.c {
        c() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.d.c
        public void a(@Nullable Bitmap cardBitmap, @NotNull GameQALinkCardData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (cardBitmap != null) {
                ab abVar = ab.this;
                w a16 = w.INSTANCE.a(cardBitmap, data);
                a16.d((EditText) abVar.mEditTextViewRef.get(), abVar);
                abVar.mLinkCardSpan = a16;
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.d.c
        public void onLoadFailed() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.d.c
        public void onLoading() {
        }
    }
}
