package com.tencent.mobileqq.guild.album;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010$\u001a\u00020#\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%\u00a2\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u001f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildAIOPickerCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "isSelected", "isGesture", "doCheckMediaSelect", "", VasPerfReportUtils.WHILE_UPDATE_ITEM, "updateVideoEditView", "Lcom/tencent/qqnt/qbasealbum/base/view/e;", "viewHolder", "bindViewHolderByState", "", "getMaxSelectNum", "getSelectState", "Landroid/content/Intent;", "intent", "initData", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "checkMediaSelect", "onMediaSelectEvent", "holder", "bindPickerHolder", "maxVideoNum", "I", "maxPhotoNum", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildAIOPickerCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PickerCustomizationBase<O> {
    private int maxPhotoNum;
    private int maxVideoNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAIOPickerCustomization(FragmentActivity activity, com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        this.maxVideoNum = 1;
        this.maxPhotoNum = 9;
    }

    private final void bindViewHolderByState(com.tencent.qqnt.qbasealbum.base.view.e viewHolder, LocalMediaInfo mediaInfo) {
        int selectState = getSelectState();
        int p16 = a.f214243a.p(mediaInfo);
        if (selectState == 0) {
            viewHolder.itemView.setClickable(true);
            ImageView q16 = viewHolder.q();
            if (q16 != null) {
                q16.setAlpha(1.0f);
            }
            QUICheckBox s16 = viewHolder.s();
            if (s16 == null) {
                return;
            }
            s16.setVisibility(0);
            return;
        }
        if (selectState != p16) {
            viewHolder.itemView.setClickable(false);
            ImageView q17 = viewHolder.q();
            if (q17 != null) {
                q17.setAlpha(0.3f);
            }
            QUICheckBox s17 = viewHolder.s();
            if (s17 == null) {
                return;
            }
            s17.setVisibility(8);
            return;
        }
        int selectStatus = mediaInfo.getSelectStatus();
        if (getPhotoCommonData().h().size() >= getMaxSelectNum() && selectStatus != 1) {
            viewHolder.itemView.setClickable(false);
            ImageView q18 = viewHolder.q();
            if (q18 != null) {
                q18.setAlpha(0.3f);
            }
            QUICheckBox s18 = viewHolder.s();
            if (s18 == null) {
                return;
            }
            s18.setVisibility(8);
            return;
        }
        viewHolder.itemView.setClickable(true);
        ImageView q19 = viewHolder.q();
        if (q19 != null) {
            q19.setAlpha(1.0f);
        }
        QUICheckBox s19 = viewHolder.s();
        if (s19 == null) {
            return;
        }
        s19.setVisibility(0);
    }

    private final boolean doCheckMediaSelect(LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        int n3 = a.f214243a.n(mediaInfo);
        int selectState = getSelectState();
        int size = getPhotoCommonData().h().size();
        if (n3 == 0) {
            if (selectState != 0 && selectState != 1) {
                return false;
            }
            if (isSelected && size >= this.maxPhotoNum) {
                return false;
            }
            return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
        }
        if (n3 != 1 || (selectState != 0 && selectState != 2)) {
            return false;
        }
        if (isSelected && size >= this.maxVideoNum) {
            return false;
        }
        return super.checkMediaSelect(mediaInfo, isSelected, isGesture);
    }

    private final int getMaxSelectNum() {
        if (getSelectState() == 1) {
            return this.maxPhotoNum;
        }
        return this.maxVideoNum;
    }

    private final int getSelectState() {
        List<LocalMediaInfo> h16 = getPhotoCommonData().h();
        if (!h16.isEmpty()) {
            return a.f214243a.q(h16.get(0)) ? 1 : 2;
        }
        return 0;
    }

    private final void updateVideoEditView(LocalMediaInfo mediaInfo, boolean isSelected) {
        if (a.f214243a.r(mediaInfo) && isSelected) {
            TextView magicBtn = getMagicBtn();
            if (magicBtn == null) {
                return;
            }
            magicBtn.setVisibility(4);
            return;
        }
        TextView magicBtn2 = getMagicBtn();
        if (magicBtn2 == null) {
            return;
        }
        magicBtn2.setVisibility(0);
    }

    private final void updateView(LocalMediaInfo mediaInfo, boolean isSelected) {
        com.tencent.qqnt.qbasealbum.a.f360732a.l();
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    public void bindPickerHolder(Context context, com.tencent.qqnt.qbasealbum.base.view.e holder, LocalMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        bindViewHolderByState(holder, mediaInfo);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public boolean checkMediaSelect(LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return doCheckMediaSelect(mediaInfo, isSelected, isGesture);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.a
    public View getBottomView(Context context, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        ViewGroup viewGroup = bottomView instanceof ViewGroup ? (ViewGroup) bottomView : null;
        Button button = viewGroup != null ? (Button) viewGroup.findViewById(R.id.f25160a3) : null;
        Button button2 = button instanceof Button ? button : null;
        if (button2 != null) {
            button2.setText(context.getString(R.string.cud));
        }
        TextView magicBtn = getMagicBtn();
        if (magicBtn != null) {
            magicBtn.setVisibility(4);
        }
        return viewGroup;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void initData(Intent intent) {
        super.initData(intent);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onMediaSelectEvent(LocalMediaInfo mediaInfo, boolean isSelected) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        updateView(mediaInfo, isSelected);
    }
}
