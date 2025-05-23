package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkShareActionSheetBuilder extends ShareActionSheetBuilder implements ShareActionSheet.b {
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f291546a0;

    /* renamed from: b0, reason: collision with root package name */
    private ImageView f291547b0;

    /* renamed from: c0, reason: collision with root package name */
    private WebView f291548c0;

    /* renamed from: d0, reason: collision with root package name */
    private o f291549d0;

    /* renamed from: e0, reason: collision with root package name */
    private QQBrowserActivity f291550e0;

    /* renamed from: f0, reason: collision with root package name */
    private RelativeLayout f291551f0;

    /* renamed from: g0, reason: collision with root package name */
    private TeamWorkFileImportInfo f291552g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (TeamWorkShareActionSheetBuilder.this.f291548c0 instanceof CustomWebView) {
                if (2 == TeamWorkShareActionSheetBuilder.this.f291549d0.f292302h) {
                    ((CustomWebView) TeamWorkShareActionSheetBuilder.this.f291548c0).callJs("openAdvPermissionsMobile()");
                    TeamWorkShareActionSheetBuilder.this.dismiss();
                } else {
                    ((CustomWebView) TeamWorkShareActionSheetBuilder.this.f291548c0).callJs("openCooperationMobile()");
                    TeamWorkShareActionSheetBuilder.this.dismiss();
                    ReportController.o(TeamWorkShareActionSheetBuilder.this.f291550e0.getAppRuntime(), "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class b implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QQBrowserActivity> f291556d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<WebView> f291557e;

        /* renamed from: f, reason: collision with root package name */
        private TeamWorkFileImportInfo f291558f;

        /* renamed from: h, reason: collision with root package name */
        private ShareActionSheet.OnItemClickListener f291559h;

        b(QQBrowserActivity qQBrowserActivity, WebView webView, TeamWorkFileImportInfo teamWorkFileImportInfo, ShareActionSheet.OnItemClickListener onItemClickListener) {
            this.f291556d = new WeakReference<>(qQBrowserActivity);
            this.f291557e = new WeakReference<>(webView);
            this.f291558f = teamWorkFileImportInfo;
            this.f291559h = onItemClickListener;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            String str;
            QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
            ShareActionSheet.OnItemClickListener onItemClickListener = this.f291559h;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(actionSheetItem, shareActionSheet);
            }
            if (this.f291558f == null) {
                return;
            }
            QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
            if (!this.f291558f.c()) {
                return;
            }
            QLog.w("TeamWorkShareActionSheetBuilder", 1, "from online preview");
            int i3 = actionSheetItem.action;
            if (i3 == 1 || i3 == 2 || i3 == 9 || i3 == 10) {
                WebView webView = this.f291557e.get();
                if (webView != null) {
                    str = webView.getUrl();
                } else {
                    str = "";
                }
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.f291558f, str, "0X8009F34");
            }
            QQBrowserActivity qQBrowserActivity = this.f291556d.get();
            if (qQBrowserActivity != null) {
                if (i3 == 1) {
                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(qQBrowserActivity.getIntent(), "0X800A16F");
                    return;
                }
                if (i3 != 2 && i3 != 9 && i3 != 10 && i3 != 3 && i3 != 12) {
                    if (i3 == 6) {
                        ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(qQBrowserActivity.getIntent(), "0X800A170");
                        return;
                    } else {
                        if (i3 == 5) {
                            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(qQBrowserActivity.getIntent(), "0X800A171");
                            return;
                        }
                        return;
                    }
                }
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(qQBrowserActivity.getIntent(), "0X800A16E");
            }
        }
    }

    public TeamWorkShareActionSheetBuilder(Context context) {
        super(context, false, 2);
        setBottomBarInterface(this);
        if (context instanceof QQBrowserActivity) {
            QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) context;
            this.f291550e0 = qQBrowserActivity;
            this.f291548c0 = qQBrowserActivity.getHostWebView();
        }
        Intent intent = new Intent();
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.KEY_SHARE_DATA_LINE_SUPPORT_TYPE, 1);
        setIntentForStartForwardRecentActivity(intent);
        setRowVisibility(0, 0, 0);
    }

    private View v() {
        QQBrowserActivity qQBrowserActivity = this.f291550e0;
        if (qQBrowserActivity == null || qQBrowserActivity.getCurrentWebViewFragment() == null) {
            return null;
        }
        this.f291549d0 = ((Share) this.f291550e0.getCurrentWebViewFragment().getShare()).y();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f291550e0).inflate(R.layout.c0l, (ViewGroup) null);
        o oVar = this.f291549d0;
        if (oVar != null && oVar.f292298d) {
            relativeLayout.setVisibility(0);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.k5k);
            this.Y = textView;
            textView.setOnClickListener(new a());
            int i3 = this.f291549d0.f292302h;
            if (i3 == 1) {
                this.Y.setText(this.f291550e0.getText(R.string.f170499sz));
            } else if (i3 == 2) {
                this.Y.setText(this.f291550e0.getText(R.string.f170128hc));
            }
            this.f291551f0 = (RelativeLayout) relativeLayout.findViewById(R.id.ifp);
            this.Y = (TextView) relativeLayout.findViewById(R.id.k5k);
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.k5i);
            this.Z = textView2;
            textView2.setTextColor(Color.parseColor("#777777"));
            if (this.f291549d0.f292302h == 2) {
                this.Z.setTextColor(Color.parseColor("#fe6c6c"));
            }
            this.Z.setText(this.f291549d0.f292295a);
            this.f291546a0 = (TextView) relativeLayout.findViewById(R.id.k5j);
            this.f291547b0 = (ImageView) relativeLayout.findViewById(R.id.f165908du2);
            o oVar2 = this.f291549d0;
            if (2 == oVar2.f292302h) {
                if (TextUtils.isEmpty(oVar2.f292296b)) {
                    this.f291546a0.setVisibility(8);
                } else {
                    this.f291546a0.setVisibility(0);
                    this.f291546a0.setText(this.f291549d0.f292296b);
                }
            } else if (TextUtils.isEmpty(oVar2.f292305k)) {
                this.f291546a0.setVisibility(8);
            } else {
                this.f291546a0.setVisibility(0);
                o oVar3 = this.f291549d0;
                u(oVar3.f292305k, oVar3.f292304j);
            }
        } else {
            relativeLayout.setVisibility(8);
        }
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.b(this.f291550e0, 70.0f)));
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.b
    public View a() {
        return v();
    }

    @Override // com.tencent.mobileqq.utils.ShareActionSheetBuilder, com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener onItemClickListener) {
        super.setItemClickListenerV2(new b(this.f291550e0, this.f291548c0, this.f291552g0, onItemClickListener));
    }

    public void u(final String str, int i3) {
        final String str2 = this.f291549d0.f292306l;
        if (i3 == 0) {
            this.f291546a0.setText(this.f291550e0.getString(R.string.hxq));
        } else {
            this.f291551f0.post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = (((TeamWorkShareActionSheetBuilder.this.f291551f0.getWidth() - ((RelativeLayout.LayoutParams) TeamWorkShareActionSheetBuilder.this.Z.getLayoutParams()).leftMargin) - 80) - TeamWorkShareActionSheetBuilder.this.f291547b0.getWidth()) - TeamWorkShareActionSheetBuilder.this.Y.getWidth();
                    float f16 = width;
                    if (TeamWorkShareActionSheetBuilder.this.f291546a0.getPaint().measureText(str + str2) > f16) {
                        int i16 = 0;
                        while (i16 < str.length()) {
                            if (TeamWorkShareActionSheetBuilder.this.f291546a0.getPaint().measureText(str.substring(0, i16) + TeamWorkShareActionSheetBuilder.this.f291550e0.getString(R.string.f170498sy) + str2) > f16) {
                                break;
                            } else {
                                i16++;
                            }
                        }
                        if (i16 == 0) {
                            TeamWorkShareActionSheetBuilder.this.f291546a0.setText(str2 + str.substring(0) + TeamWorkShareActionSheetBuilder.this.f291550e0.getString(R.string.f170498sy));
                            return;
                        }
                        String substring = str.substring(0, i16 - 1);
                        TeamWorkShareActionSheetBuilder.this.f291546a0.setText(str2 + substring + TeamWorkShareActionSheetBuilder.this.f291550e0.getString(R.string.f170498sy));
                        return;
                    }
                    TeamWorkShareActionSheetBuilder.this.f291546a0.setText(str2 + str);
                }
            });
        }
    }

    public void w(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        this.f291552g0 = teamWorkFileImportInfo;
    }
}
