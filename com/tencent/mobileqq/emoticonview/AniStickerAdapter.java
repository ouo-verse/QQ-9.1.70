package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AniStickerAdapter extends SystemAndEmojiAdapter {
    static IPatchRedirector $redirector_ = null;
    private static final int COLUMN_NUM = 5;
    private static final float DEFAULT_EMOJI_WIDTH = 63.5f;
    private static final int MIN_HORIZONTAL_SPACE_WIDTH = 8;
    private static final String TAG = "AniStickerAdapter";
    private boolean isSelected;
    private final Set<Integer> reportPackageIdSet;

    public AniStickerAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelListener iPanelListener, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback, int i18, boolean z16) {
        super(iEmoticonMainPanelApp, iPanelListener, context, i3, i16, i17, emoticonCallback, i18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback, Integer.valueOf(i18), Boolean.valueOf(z16));
        } else {
            this.reportPackageIdSet = new CopyOnWriteArraySet();
            this.isSelected = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdapterSelected$1() {
        AppRuntime appRuntime = this.app.getAppRuntime();
        Iterator<Integer> it = this.reportPackageIdSet.iterator();
        while (it.hasNext()) {
            reportPackageId(appRuntime, it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportItemTypeTitle$0(int i3) {
        reportPackageId(this.app.getAppRuntime(), i3);
    }

    private void reportPackageId(AppRuntime appRuntime, int i3) {
        ReportController.o(appRuntime, "dc00898", "", "", "0X800C5C1", "0X800C5C1", 0, 0, String.valueOf(i3), "", "", "");
    }

    @Override // com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter
    protected Drawable getEmotionViewFaceDrawable(@NonNull SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) systemAndEmojiEmoticonInfo);
        }
        return systemAndEmojiEmoticonInfo.getBigDrawable(this.mContext, this.density);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void onAdapterSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.isSelected = true;
        if (this.reportPackageIdSet.size() > 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.a
                @Override // java.lang.Runnable
                public final void run() {
                    AniStickerAdapter.this.lambda$onAdapterSelected$1();
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void onAdapterUnselected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.isSelected = false;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.SystemAndEmojiAdapter
    protected void reportItemTypeTitle(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            if (this.reportPackageIdSet.contains(Integer.valueOf(i3))) {
                return;
            }
            this.reportPackageIdSet.add(Integer.valueOf(i3));
            if (this.isSelected) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AniStickerAdapter.this.lambda$reportItemTypeTitle$0(i3);
                    }
                }, 16, null, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void setWidthPixels(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        super.setWidthPixels(i3);
        this.columnNum = 5;
        this.emojiWidth = ViewUtils.dpToPx(DEFAULT_EMOJI_WIDTH);
        if (i3 <= 0) {
            QLog.e(TAG, 1, "[setWidthPixels] invalidate widthPixels=", Integer.valueOf(i3));
            return;
        }
        int calculateSpaceWidth = calculateSpaceWidth();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[setWidthPixels] widthPixels=", Integer.valueOf(i3), ", spaceWidth=", Integer.valueOf(calculateSpaceWidth));
        }
        if (calculateSpaceWidth < ViewUtils.dpToPx(8.0f)) {
            int pxToDp = ViewUtils.pxToDp(i3) - 36;
            int i16 = this.columnNum;
            this.emojiWidth = ViewUtils.dpToPx((pxToDp - ((i16 - 1) * 8)) / i16);
        }
    }
}
