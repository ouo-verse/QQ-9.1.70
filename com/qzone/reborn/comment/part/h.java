package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.feed.business.model.QQEmoCommentDataManager;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.qzone.widget.RapidCommentEmoView;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u0017\u001a\u00020\u00052\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/comment/part/h;", "Lcom/qzone/reborn/base/k;", "Lxc/c;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "P9", "O9", "N9", "Landroid/widget/EditText;", "editText", "L9", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "emoticonInfo", "Q9", "Lcom/qzone/widget/RapidCommentExpressionInfo;", "rapidCommentExpressionInfo", "S9", "I9", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "decryptFilePath", "M9", "onInitView", "getLogTag", "Landroid/view/ViewGroup;", "layoutView", "J0", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mEmoIcon", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "f", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "mPrivateCommentIcon", "Lcom/qzone/widget/RapidCommentEmoView;", tl.h.F, "Lcom/qzone/widget/RapidCommentEmoView;", "mEmoPanelView", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "i", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "mEmoticonCallback", "Ldd/b;", BdhLogUtil.LogTag.Tag_Conn, "Ldd/b;", "mInputViewModel", "", "D", "Z", "mUseQQEmo", "Landroid/view/View$OnClickListener;", "E", "Landroid/view/View$OnClickListener;", "onRapidCommentViewClickListener", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends com.qzone.reborn.base.k implements xc.c {

    /* renamed from: C, reason: from kotlin metadata */
    private dd.b mInputViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean mUseQQEmo;

    /* renamed from: E, reason: from kotlin metadata */
    private final View.OnClickListener onRapidCommentViewClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mEmoIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox mPrivateCommentIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RapidCommentEmoView mEmoPanelView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private EmoticonCallback mEmoticonCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"com/qzone/reborn/comment/part/h$b", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "", "send", "", NodeProps.ON_LONG_CLICK, "delete", "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements EmoticonCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            h hVar = h.this;
            QZoneCommentEditText qZoneCommentEditText = hVar.mEtInput;
            if (qZoneCommentEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText = null;
            }
            hVar.L9(qZoneCommentEditText);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo oldInfo, EmoticonInfo newInfo, Drawable d16) {
            Intrinsics.checkNotNullParameter(oldInfo, "oldInfo");
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
            Intrinsics.checkNotNullParameter(d16, "d");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            h hVar = h.this;
            QZoneCommentEditText qZoneCommentEditText = hVar.mEtInput;
            if (qZoneCommentEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText = null;
            }
            hVar.Q9(qZoneCommentEditText, info);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }
    }

    public h(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
        this.mUseQQEmo = com.qzone.reborn.configx.g.f53821a.a().p();
        this.onRapidCommentViewClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.R9(h.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(RapidCommentExpressionInfo rapidCommentExpressionInfo, final h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String u16 = QQEmoCommentDataManager.C().u(rapidCommentExpressionInfo.f60639d, Long.valueOf(rapidCommentExpressionInfo.f60640e));
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.comment.part.g
            @Override // java.lang.Runnable
            public final void run() {
                h.K9(u16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(String str, h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this$0.M9(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(EditText editText) {
        int coerceAtMost;
        int coerceAtLeast;
        try {
            int selectionStart = editText.getSelectionStart();
            if (selectionStart == 0) {
                return;
            }
            Editable text = editText.getText();
            Intrinsics.checkNotNullExpressionValue(text, "editText.text");
            int offsetBefore = TextUtils.getOffsetBefore(editText.getText(), selectionStart);
            if (selectionStart != offsetBefore) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(selectionStart, offsetBefore);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(selectionStart, offsetBefore);
                text.delete(coerceAtMost, coerceAtLeast);
            }
        } catch (Exception e16) {
            RFWLog.fatal("QZoneCommentPanelEmotionPart", RFWLog.USR, e16);
        }
    }

    private final void M9(ArrayList<String> decryptFilePath) {
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = new QZoneCommentPanelResultBean();
        qZoneCommentPanelResultBean.C("");
        qZoneCommentPanelResultBean.y(decryptFilePath);
        qZoneCommentPanelResultBean.v("");
        QUICheckBox qUICheckBox = this.mPrivateCommentIcon;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentIcon");
            qUICheckBox = null;
        }
        qZoneCommentPanelResultBean.x(qUICheckBox.isChecked());
        qZoneCommentPanelResultBean.u(this.initParams.getCacheFeedsKey());
        QLog.i("QZoneCommentPanelEmotionPart", 1, "[handleQQExpressionClickEvent] resultBean:" + qZoneCommentPanelResultBean);
        Intent intent = new Intent();
        intent.putExtra("comment_panel_result_bean", qZoneCommentPanelResultBean);
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void N9() {
        this.mEmoticonCallback = new b();
    }

    private final void O9() {
        RapidCommentEmoView rapidCommentEmoView;
        EmoticonCallback emoticonCallback;
        RapidCommentEmoView rapidCommentEmoView2 = this.mEmoPanelView;
        ImageView imageView = null;
        if (rapidCommentEmoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanelView");
            rapidCommentEmoView2 = null;
        }
        rapidCommentEmoView2.setIsActionPanel(true);
        RapidCommentEmoView rapidCommentEmoView3 = this.mEmoPanelView;
        if (rapidCommentEmoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanelView");
            rapidCommentEmoView = null;
        } else {
            rapidCommentEmoView = rapidCommentEmoView3;
        }
        Activity activity = getActivity();
        EmoticonCallback emoticonCallback2 = this.mEmoticonCallback;
        if (emoticonCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoticonCallback");
            emoticonCallback = null;
        } else {
            emoticonCallback = emoticonCallback2;
        }
        rapidCommentEmoView.i(activity, true, emoticonCallback, this.initParams.getEnablePicComment() && this.initParams.getEnableEmoRapidComment() && !this.mUseQQEmo, this.onRapidCommentViewClickListener, this.initParams.getEnableEmoRapidComment() && this.mUseQQEmo, this.initParams.getNeedShowFavoritesEmo());
        RapidCommentEmoView rapidCommentEmoView4 = this.mEmoPanelView;
        if (rapidCommentEmoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanelView");
            rapidCommentEmoView4 = null;
        }
        rapidCommentEmoView4.getLayoutParams().height = (int) ((ViewUtils.getScreenWidth() * 0.51180553f) + RapidCommentEmoView.U);
        ImageView imageView2 = this.mEmoIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
        } else {
            imageView = imageView2;
        }
        fo.c.n(imageView, "em_qz_emoticon");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(EditText editText, EmoticonInfo emoticonInfo) {
        String emojiString;
        try {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = editText.getSelectionStart();
                int selectionEnd = editText.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                if (emoticonInfo.type == 1) {
                    emojiString = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code);
                } else {
                    emojiString = com.tencent.mobileqq.text.TextUtils.getEmojiString(((SystemEmoticonInfo) emoticonInfo).code);
                }
                editText.getEditableText().replace(selectionStart, selectionEnd, emojiString);
            }
        } catch (Exception e16) {
            RFWLog.fatal("QZoneCommentPanelEmotionPart", RFWLog.USR, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getTag() instanceof RapidCommentExpressionInfo) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.qzone.widget.RapidCommentExpressionInfo");
            RapidCommentExpressionInfo rapidCommentExpressionInfo = (RapidCommentExpressionInfo) tag;
            if (this$0.mUseQQEmo) {
                this$0.I9(rapidCommentExpressionInfo);
            } else {
                QZoneCommentPanelResultBean qZoneCommentPanelResultBean = new QZoneCommentPanelResultBean();
                qZoneCommentPanelResultBean.C("");
                qZoneCommentPanelResultBean.v("");
                QUICheckBox qUICheckBox = this$0.mPrivateCommentIcon;
                if (qUICheckBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPrivateCommentIcon");
                    qUICheckBox = null;
                }
                qZoneCommentPanelResultBean.x(qUICheckBox.isChecked());
                qZoneCommentPanelResultBean.u(this$0.initParams.getCacheFeedsKey());
                qZoneCommentPanelResultBean.E(rapidCommentExpressionInfo);
                qZoneCommentPanelResultBean.z(true);
                QLog.i("QZoneCommentPanelEmotionPart", 1, "[sendCommentContent] resultBean:" + qZoneCommentPanelResultBean);
                Intent intent = new Intent();
                intent.putExtra("comment_panel_result_bean", qZoneCommentPanelResultBean);
                Activity activity = this$0.getActivity();
                if (activity != null) {
                    activity.setResult(-1, intent);
                }
                Activity activity2 = this$0.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
            this$0.S9(rapidCommentExpressionInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // xc.c
    public void J0(ViewGroup layoutView) {
        ImageView imageView = this.mEmoIcon;
        RapidCommentEmoView rapidCommentEmoView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.qui_keyboard_circle);
        ImageView imageView2 = this.mEmoIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
            imageView2 = null;
        }
        imageView2.setContentDescription(com.qzone.util.l.a(R.string.f2202768o));
        RapidCommentEmoView rapidCommentEmoView2 = this.mEmoPanelView;
        if (rapidCommentEmoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanelView");
            rapidCommentEmoView2 = null;
        }
        rapidCommentEmoView2.setVisibility(0);
        RapidCommentEmoView rapidCommentEmoView3 = this.mEmoPanelView;
        if (rapidCommentEmoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoPanelView");
        } else {
            rapidCommentEmoView = rapidCommentEmoView3;
        }
        rapidCommentEmoView.l();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneCommentPanelEmotionPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        registerIoc(this, xc.c.class);
        P9(rootView);
        N9();
        O9();
    }

    private final void S9(RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        String str = rapidCommentExpressionInfo.f60639d;
        long j3 = rapidCommentExpressionInfo.f60640e;
        ClickReport.j(LoginData.getInstance().getUin(), "", "", "", true, "359", "2", str + "_" + j3, "", "", str, String.valueOf(j3));
        if (Intrinsics.areEqual("fav_tab_id", rapidCommentExpressionInfo.f60639d)) {
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(431, 12, 2), false, true);
            com.tencent.mobileqq.webview.util.y.a(LoginData.getInstance().getUinString(), null, null, null, 0, 0L, "ep_mall", "send_collection", "0", 0, 0, 1, null, "", "1", null, null);
        } else {
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(431, 12, 5), false, true);
            com.tencent.mobileqq.webview.util.y.a(LoginData.getInstance().getUinString(), null, null, null, 0, 0L, "ep_mall", "send_emoticon", "0", 0, 0, 1, null, rapidCommentExpressionInfo.f60639d, "1", null, null);
        }
    }

    private final void I9(final RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        if (rapidCommentExpressionInfo == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.comment.part.f
            @Override // java.lang.Runnable
            public final void run() {
                h.J9(RapidCommentExpressionInfo.this, this);
            }
        });
    }

    private final void P9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162815ms2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026e_comment_panel_emo_icon)");
        this.mEmoIcon = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.msj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026mment_panel_private_icon)");
        this.mPrivateCommentIcon = (QUICheckBox) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162816ms3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026e_comment_panel_emo_view)");
        this.mEmoPanelView = (RapidCommentEmoView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById4;
        ImageView imageView = this.mEmoIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmoIcon");
            imageView = null;
        }
        imageView.setVisibility(0);
    }
}
