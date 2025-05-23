package com.qzone.reborn.comment.part;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.ViewModel;
import cd.n;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.reborn.comment.bean.GroupCommentParam;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.widget.QZoneCommentEditText;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\"\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/comment/part/c;", "Lcom/qzone/reborn/base/k;", "Lxc/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "F9", "E9", "onInitView", Constants.APK_CERTIFICATE, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "H9", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "d", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "getInitParams", "()Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "e", "Lcom/qzone/reborn/comment/widget/QZoneCommentEditText;", "mEtInput", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mAtIcon", "Ldd/b;", tl.h.F, "Ldd/b;", "mInputViewModel", "<init>", "(Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends com.qzone.reborn.base.k implements xc.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QZoneCommentPanelParams initParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneCommentEditText mEtInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mAtIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private dd.b mInputViewModel;

    public c(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        this.initParams = initParams;
    }

    private final void E9() {
        ImageView imageView = this.mAtIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtIcon");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView3 = this.mAtIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtIcon");
        } else {
            imageView2 = imageView3;
        }
        fo.c.n(imageView2, "em_qz_at_people");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n.Companion companion = cd.n.INSTANCE;
        QZoneCommentEditText qZoneCommentEditText = this$0.mEtInput;
        if (qZoneCommentEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            qZoneCommentEditText = null;
        }
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.c(qZoneCommentEditText, activity);
    }

    @Override // xc.a
    public void G1() {
        GroupCommentParam groupCommentParam = this.initParams.getGroupCommentParam();
        if (groupCommentParam != null) {
            ho.i.g().g(getActivity(), groupCommentParam.getGroupId(), groupCommentParam.getGroupName());
        } else {
            ho.i.g().f(getActivity());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, xc.a.class);
        ViewModel viewModel = getViewModel(dd.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneInputViewModel::class.java)");
        this.mInputViewModel = (dd.b) viewModel;
        F9(rootView);
        E9();
    }

    private final void F9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ms_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026zone_comment_panel_input)");
        this.mEtInput = (QZoneCommentEditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mrx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ne_comment_panel_at_icon)");
        ImageView imageView = (ImageView) findViewById2;
        this.mAtIcon = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.qui_at);
        ImageView imageView3 = this.mAtIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtIcon");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.comment.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.G9(c.this, view);
            }
        });
    }

    public final void H9(Intent data) {
        String str;
        if (data == null) {
            return;
        }
        dd.b bVar = this.mInputViewModel;
        QZoneCommentEditText qZoneCommentEditText = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
            bVar = null;
        }
        if (bVar.getIsInputAtByUser()) {
            QZoneCommentEditText qZoneCommentEditText2 = this.mEtInput;
            if (qZoneCommentEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText2 = null;
            }
            int selectionStart = qZoneCommentEditText2.getSelectionStart();
            QZoneCommentEditText qZoneCommentEditText3 = this.mEtInput;
            if (qZoneCommentEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText3 = null;
            }
            Editable editableText = qZoneCommentEditText3.getEditableText();
            Intrinsics.checkNotNullExpressionValue(editableText, "mEtInput.editableText");
            if (selectionStart > 0) {
                int i3 = selectionStart - 1;
                String substring = editableText.toString().substring(i3, selectionStart);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                if (Intrinsics.areEqual(substring, "@")) {
                    editableText.delete(i3, selectionStart);
                }
            }
            dd.b bVar2 = this.mInputViewModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                bVar2 = null;
            }
            bVar2.d2(false);
        }
        ArrayList parcelableArrayListExtra = data.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
        if (parcelableArrayListExtra != null) {
            Iterator it = parcelableArrayListExtra.iterator();
            String str2 = "";
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                ResultRecord resultRecord = (ResultRecord) it.next();
                Friend friend = new Friend();
                String str3 = resultRecord.name;
                if (str3 != null && str3.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    str = resultRecord.uin;
                } else {
                    str = resultRecord.name;
                }
                friend.mName = str;
                long k3 = ef.d.k(resultRecord.uin);
                friend.mUin = k3;
                if (friend.mName != null && k3 != 0) {
                    dd.b bVar3 = this.mInputViewModel;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                        bVar3 = null;
                    }
                    bVar3.M1(friend);
                    str2 = str2 + ("@" + friend.mName + " ");
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            QZoneCommentEditText qZoneCommentEditText4 = this.mEtInput;
            if (qZoneCommentEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText4 = null;
            }
            qZoneCommentEditText4.requestFocus();
            QZoneCommentEditText qZoneCommentEditText5 = this.mEtInput;
            if (qZoneCommentEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
                qZoneCommentEditText5 = null;
            }
            int selectionStart2 = qZoneCommentEditText5.getSelectionStart();
            QZoneCommentEditText qZoneCommentEditText6 = this.mEtInput;
            if (qZoneCommentEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEtInput");
            } else {
                qZoneCommentEditText = qZoneCommentEditText6;
            }
            com.qzone.util.am.g(str2, selectionStart2, qZoneCommentEditText);
            if (this.initParams.getIsShare()) {
                cd.n.INSTANCE.a(getActivity(), true);
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.comment.part.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.I9(c.this);
                    }
                }, 200L);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (20221 == requestCode) {
            if (resultCode == -1) {
                H9(data);
                return;
            }
            dd.b bVar = this.mInputViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputViewModel");
                bVar = null;
            }
            bVar.d2(false);
        }
    }
}
