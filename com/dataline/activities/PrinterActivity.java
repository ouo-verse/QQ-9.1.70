package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.util.i;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.d;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import cooperation.peak.PeakConstants;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PrinterActivity extends IphoneTitleBarActivity implements View.OnClickListener {

    /* renamed from: a0, reason: collision with root package name */
    private Button f32237a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f32238b0;

    /* renamed from: d0, reason: collision with root package name */
    public ViewGroup f32240d0;

    /* renamed from: e0, reason: collision with root package name */
    public XListView f32241e0;

    /* renamed from: c0, reason: collision with root package name */
    private DataLineHandler f32239c0 = null;

    /* renamed from: f0, reason: collision with root package name */
    public ScrollerRunnable f32242f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    private RelativeLayout f32243g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f32244h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f32245i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f32246j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    private AsyncImageView f32247k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    private long f32248l0 = 0;

    /* renamed from: m0, reason: collision with root package name */
    private String f32249m0 = "";

    /* renamed from: n0, reason: collision with root package name */
    private String f32250n0 = "";

    /* renamed from: o0, reason: collision with root package name */
    private String f32251o0 = "";

    /* renamed from: p0, reason: collision with root package name */
    private k f32252p0 = new b();

    /* loaded from: classes.dex */
    class b extends k {
        b() {
        }

        @Override // com.tencent.mobileqq.app.k
        protected void d(Object obj, boolean z16) {
            if (z16 && PrinterActivity.this.J2()) {
                PrinterActivity.this.K2(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J2() {
        String d16 = cl.d(this, "hp_bind_tip_key");
        if (TextUtils.isEmpty(d16)) {
            return true;
        }
        if (System.currentTimeMillis() - Long.parseLong(d16) > 2592000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(Object obj) {
        if (this.f32243g0 == null) {
            LayoutInflater.from(this).inflate(R.layout.f167887kp, this.f32240d0, true);
            this.f32243g0 = (RelativeLayout) this.f32240d0.findViewById(R.id.a_d);
            this.f32244h0 = (TextView) this.f32240d0.findViewById(R.id.a_e);
            this.f32245i0 = (TextView) this.f32240d0.findViewById(R.id.a_b);
            this.f32246j0 = (TextView) this.f32240d0.findViewById(R.id.a_c);
            this.f32247k0 = (AsyncImageView) this.f32240d0.findViewById(R.id.c_6);
            this.f32247k0.setImageDrawable(super.getResources().getDrawable(R.drawable.cpn));
        }
        Object[] objArr = (Object[]) obj;
        this.f32248l0 = ((Long) objArr[0]).longValue();
        this.f32249m0 = (String) objArr[1];
        this.f32250n0 = (String) objArr[2];
        this.f32251o0 = (String) objArr[3];
        RelativeLayout relativeLayout = this.f32243g0;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 56 && i16 == -1) {
            ArrayList<? extends Parcelable> parcelableArrayListExtra = intent.getParcelableArrayListExtra("sFilesSelected");
            Intent intent2 = new Intent(this, (Class<?>) PrinterOptionActivity.class);
            intent2.setClass(this, PrinterOptionActivity.class);
            intent2.putParcelableArrayListExtra("sFilesSelected", parcelableArrayListExtra);
            intent2.putExtra(d.f307603i, i3);
            super.startActivityForResult(intent2, 102);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        super.getWindow().setBackgroundDrawableResource(R.color.f156897em);
        super.setContentView(R.layout.f167882kk);
        super.setTitle(R.string.ago);
        super.getWindow().setBackgroundDrawable(null);
        FrameLayout frameLayout = (FrameLayout) super.findViewById(R.id.bdh);
        this.f32240d0 = frameLayout;
        frameLayout.setTag(R.id.f163835o, "n/a");
        Button button = (Button) super.findViewById(R.id.jfl);
        this.f32237a0 = button;
        button.setOnClickListener(this);
        Button button2 = (Button) super.findViewById(R.id.jfm);
        this.f32238b0 = button2;
        button2.setOnClickListener(this);
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        this.f32239c0 = dataLineHandler;
        dataLineHandler.D.f194912i = new i(this, this.f32239c0);
        XListView xListView = (XListView) super.findViewById(R.id.ec_);
        this.f32241e0 = xListView;
        this.f32242f0 = new ScrollerRunnable(xListView);
        this.f32241e0.setAdapter((ListAdapter) this.f32239c0.D.f194912i);
        View inflate = LayoutInflater.from(this).inflate(R.layout.f167787hh, (ViewGroup) null);
        this.f32241e0.setOverscrollHeader(super.getResources().getDrawable(R.drawable.els));
        this.f32241e0.setOverScrollHeader(inflate);
        this.f32241e0.setOverScrollListener(new a());
        this.app.addObserver(this.f32252p0);
        PrinterStatusHandler printerStatusHandler = (PrinterStatusHandler) this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
        if (J2()) {
            printerStatusHandler.G2();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        PrinterHandler printerHandler = this.f32239c0.D;
        printerHandler.f194912i = null;
        printerHandler.a();
        ScrollerRunnable scrollerRunnable = this.f32242f0;
        if (scrollerRunnable != null) {
            scrollerRunnable.stop();
        }
        this.app.removeObserver(this.f32252p0);
        RelativeLayout relativeLayout = this.f32243g0;
        if (relativeLayout != null) {
            this.f32240d0.removeView(relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        LiteActivity.G4(this, this.f32240d0);
        this.f32239c0.D.f194912i.notifyDataSetChanged();
        LiteActivity.n3(this.f32242f0, this.f32241e0);
        LiteActivity.h4(this.f32241e0);
        Intent intent = super.getIntent();
        String str = d.f307603i;
        int intExtra = intent.getIntExtra(str, -1);
        if (55 == intExtra || intExtra == 57) {
            intent.removeExtra(str);
            ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new FileInfo(it.next()));
                } catch (FileNotFoundException unused) {
                }
            }
            if (arrayList.size() > 0) {
                Intent intent2 = new Intent(this, (Class<?>) PrinterOptionActivity.class);
                intent2.putExtra(d.f307603i, intExtra);
                intent2.putParcelableArrayListExtra("sFilesSelected", arrayList);
                startActivityForResult(intent2, 102);
                return;
            }
            LiteActivity.Q4(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.jfl) {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByPrinter(this, this.f32239c0.D.b(), 56);
            QAlbumUtil.anim(this, false, true);
            ReportController.o(this.app, "CliOper", "", "", "0X8004018", "0X8004018", 0, 0, "", "", "", "");
        } else if (id5 == R.id.jfm) {
            Intent intent = new Intent(this, (Class<?>) NewPhotoListActivity.class);
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PrinterActivity.class.getName());
            intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 5);
            intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            intent.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, true);
            intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
            intent.putExtra(d.f307603i, 57);
            intent.putExtra("uin", AppConstants.DATALINE_PRINTER_UIN);
            intent.putExtra(PeakConstants.IS_SEND_FILESIZE_LIMIT, true);
            intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
            intent.getExtras().remove("forward_type");
            intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
            intent.putExtra("STRING_Show_Within_Suffixs", this.f32239c0.D.b());
            super.startActivity(intent);
            QAlbumUtil.anim(this, false, true);
            ReportController.o(this.app, "CliOper", "", "", "0X8004019", "0X8004019", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* loaded from: classes.dex */
    class a implements OverScrollViewListener {
        a() {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            int h16 = PrinterActivity.this.f32239c0.D.h();
            if (h16 > 0) {
                PrinterActivity.this.f32239c0.D.f194912i.e();
                PrinterActivity.this.f32241e0.setSelectionFromBottom(h16, 0);
                PrinterActivity.this.f32239c0.D.f194912i.notifyDataSetChanged();
            }
            return false;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        }
    }
}
