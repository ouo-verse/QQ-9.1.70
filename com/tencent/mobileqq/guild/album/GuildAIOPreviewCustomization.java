package com.tencent.mobileqq.guild.album;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/album/GuildAIOPreviewCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "updateUI", "onGalleryItemSelected", "", "getMaxNum", "flag", "updateSelectableUI", "updateMagicStick", "getSelectState", "position", "", "needGestureUp", "maxVideoNum", "I", "maxPhotoNum", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildAIOPreviewCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PreviewCustomizationBase<O> {
    private int maxPhotoNum;
    private int maxVideoNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAIOPreviewCustomization(FragmentActivity activity, com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        this.maxVideoNum = 1;
        this.maxPhotoNum = 9;
    }

    private final int getMaxNum(LocalMediaInfo mediaInfo) {
        if (a.f214243a.q(mediaInfo)) {
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

    private final void updateMagicStick(LocalMediaInfo mediaInfo) {
        TextView magicStickBtn;
        if (!a.f214243a.r(mediaInfo) || (magicStickBtn = getMagicStickBtn()) == null) {
            return;
        }
        magicStickBtn.setEnabled(false);
    }

    private final void updateSelectableUI(int flag) {
        CheckBox selectedBox = getSelectedBox();
        if (selectedBox != null) {
            selectedBox.setVisibility(flag);
        }
        CheckBox qualityCb = getQualityCb();
        if (qualityCb != null) {
            qualityCb.setVisibility(flag);
        }
        TextView qualityTv = getQualityTv();
        if (qualityTv != null) {
            qualityTv.setVisibility(flag);
        }
        boolean z16 = flag == 0;
        CheckBox selectedBox2 = getSelectedBox();
        if (selectedBox2 != null) {
            selectedBox2.setEnabled(z16);
        }
        CheckBox qualityCb2 = getQualityCb();
        if (qualityCb2 != null) {
            qualityCb2.setEnabled(z16);
        }
        TextView qualityTv2 = getQualityTv();
        if (qualityTv2 == null) {
            return;
        }
        qualityTv2.setEnabled(z16);
    }

    private final void updateUI(LocalMediaInfo mediaInfo) {
        if (a.f214243a.r(mediaInfo)) {
            TextView magicStickBtn = getMagicStickBtn();
            if (magicStickBtn != null) {
                magicStickBtn.setVisibility(4);
            }
        } else {
            TextView magicStickBtn2 = getMagicStickBtn();
            if (magicStickBtn2 != null) {
                magicStickBtn2.setVisibility(0);
            }
        }
        Button sendBtn = getSendBtn();
        if (sendBtn == null) {
            return;
        }
        sendBtn.setText(getActivity().getString(R.string.cud));
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    public boolean needGestureUp() {
        return false;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic
    public void onGalleryItemSelected(LocalMediaInfo mediaInfo, int position) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        super.onGalleryItemSelected(mediaInfo, position);
        onGalleryItemSelected(mediaInfo);
        updateUI(mediaInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
    
        if (r0 >= r4) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onGalleryItemSelected(LocalMediaInfo mediaInfo) {
        int selectState = getSelectState();
        int p16 = a.f214243a.p(getPreviewData().a());
        int i3 = 0;
        int i16 = 8;
        if (selectState != 0 && ((selectState != 1 && selectState != 2) || p16 != selectState)) {
            i3 = 8;
        }
        if (i3 == 0) {
            int size = getPhotoCommonData().h().size();
            boolean contains = getPhotoCommonData().h().contains(mediaInfo);
            int maxNum = getMaxNum(mediaInfo);
            if (!contains) {
            }
        }
        i16 = i3;
        updateSelectableUI(i16);
        updateMagicStick(mediaInfo);
    }
}
