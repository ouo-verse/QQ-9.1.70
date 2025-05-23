package com.qzone.publish.ui.state;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.reborn.util.l;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.ExtendEditText;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends com.qzone.publish.ui.state.a {

    /* renamed from: j, reason: collision with root package name */
    private final String f52067j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f52068k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ActionSheet actionSheet;
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = b.this.f52057a.get();
            if (qZonePublishMoodBaseActivity == null || (actionSheet = b.this.f52063g) == null) {
                return;
            }
            if (i3 == 2) {
                actionSheet.superDismiss();
            } else {
                qZonePublishMoodBaseActivity.finish();
            }
        }
    }

    public b(QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        super(qZonePublishMoodBaseActivity);
        this.f52067j = "PublishMoodStateDynamicAlbum";
        this.f52068k = false;
    }

    private void s() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        ActionSheet actionSheet = this.f52063g;
        if (actionSheet == null || !actionSheet.isShowing()) {
            ShuoshuoContent shuoshuoContent = new ShuoshuoContent();
            if (qZonePublishMoodBaseActivity.f45104j0 != null) {
                shuoshuoContent.setTextDraft("");
            }
            u5.b.N0(shuoshuoContent, g());
            ExtendEditText extendEditText = qZonePublishMoodBaseActivity.f45104j0;
            if (extendEditText != null && TextUtils.isEmpty(extendEditText.getText().toString())) {
                qZonePublishMoodBaseActivity.U2 = false;
                qZonePublishMoodBaseActivity.finish();
                return;
            }
            ActionSheet create = ActionSheet.create(qZonePublishMoodBaseActivity.getActivity());
            this.f52063g = create;
            create.setMainTitle(R.string.glg);
            this.f52063g.addButton(R.string.glf, 1);
            this.f52063g.addCancelButton(R.string.cancel);
            this.f52063g.setOnButtonClickListener(new a());
            this.f52063g.show();
        }
    }

    @Override // com.qzone.publish.ui.state.a
    public void b() {
        View a16;
        if (this.f52057a.get() == null || (a16 = a(R.id.fpf)) == null) {
            return;
        }
        a16.setVisibility(8);
    }

    @Override // com.qzone.publish.ui.state.a
    public int h() {
        return 3;
    }

    @Override // com.qzone.publish.ui.state.a
    public void i(Intent intent) {
        this.f52068k = intent.getBooleanExtra(QZoneJsConstants.DYNAMIC_ALBUM_IS_FROM_DRAFT, false);
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        if (this.f52062f == 0) {
            this.f52062f = LoginData.getInstance().getUin();
        }
        ArrayList<DynamicPhotoData> parcelableArrayListExtra = intent.getParcelableArrayListExtra(QZoneJsConstants.DYNAMIC_ALBUM_PHOTOLIST);
        qZonePublishMoodBaseActivity.Q4 = parcelableArrayListExtra;
        Iterator<DynamicPhotoData> it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            String replace = it.next().mUrl.replace("https://www.dynamicalbumlocalimage.com", "");
            if (!qZonePublishMoodBaseActivity.oj().contains(replace)) {
                qZonePublishMoodBaseActivity.oj().add(replace);
            }
        }
        a(R.id.br6).setVisibility(0);
        AsyncImageView asyncImageView = (AsyncImageView) a(R.id.br7);
        asyncImageView.setVisibility(0);
        asyncImageView.setDefaultImage(R.drawable.asd);
        int dpToPx = ViewUtils.dpToPx(152.0f);
        asyncImageView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor(dpToPx, dpToPx));
        asyncImageView.setAsyncImage(qZonePublishMoodBaseActivity.oj().get(0));
        String G = l.f59550a.G(qZonePublishMoodBaseActivity.bj(), intent);
        if (TextUtils.isEmpty(G)) {
            return;
        }
        qZonePublishMoodBaseActivity.setTitle(G);
    }

    @Override // com.qzone.publish.ui.state.a
    public void r() {
        ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 3, "1", true, new String[0]);
        s();
    }
}
