package com.qzone.album.ui.activity;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.qzone.album.base.Service.QzoneAlbumPicDownloadService;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.QZoneFragmentHolderActivity;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;
import com.qzone.common.event.IObserver;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.l;
import com.qzone.widget.ExtendGridView;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import e9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzDynamicVideoEditActivity extends BaseFragment implements View.OnClickListener, IObserver.main {
    private static final String S = "QzDynamicVideoEditActivity";
    private DynamicGridView C;
    private e9.a D;
    private TextView I;
    private TextView J;
    private Button K;
    private Dialog L;
    private TextView M;
    private int P;
    private com.qzone.common.business.service.b Q;
    private DynamicArrayList<String> E = new DynamicArrayList<>();
    private DynamicArrayList<String> F = new DynamicArrayList<>();
    private ArrayList<PictureItem> G = null;
    private ArrayList<SlideItemInfo> H = new ArrayList<>();
    private boolean N = false;
    private final xk.d R = new xk.d(new d());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            RDMEtraMsgCollector.getInstance().addNormalItemClickAction(QzDynamicVideoEditActivity.this.simpleClassname, adapterView, view, i3, j3);
            if (QzDynamicVideoEditActivity.this.D.d0(i3) && QzDynamicVideoEditActivity.this.D.H(view)) {
                QzDynamicVideoEditActivity.this.Sh();
                return;
            }
            QzDynamicVideoEditActivity qzDynamicVideoEditActivity = QzDynamicVideoEditActivity.this;
            qzDynamicVideoEditActivity.Th(qzDynamicVideoEditActivity.C, i3 - 1, QzDynamicVideoEditActivity.this.E, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements g {
        e() {
        }

        @Override // com.qzone.album.ui.activity.QzDynamicVideoEditActivity.g
        public void a(DynamicArrayList<String> dynamicArrayList) {
            QzDynamicVideoEditActivity.this.E = dynamicArrayList;
            QzDynamicVideoEditActivity qzDynamicVideoEditActivity = QzDynamicVideoEditActivity.this;
            qzDynamicVideoEditActivity.Lh(qzDynamicVideoEditActivity.E);
            QzDynamicVideoEditActivity.this.D.q(QzDynamicVideoEditActivity.this.E);
            QzDynamicVideoEditActivity.this.D.notifyDataSetChanged();
            QzDynamicVideoEditActivity.this.Vh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f44112d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f44113e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DynamicArrayList f44114f;

        f(ArrayList arrayList, g gVar, DynamicArrayList dynamicArrayList) {
            this.f44112d = arrayList;
            this.f44113e = gVar;
            this.f44114f = dynamicArrayList;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (QzDynamicVideoEditActivity.this.N) {
                u4.a.z().k(this.f44112d);
                QzDynamicVideoEditActivity.this.N = false;
                this.f44113e.a(this.f44114f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface g {
        void a(DynamicArrayList<String> dynamicArrayList);
    }

    private void Eh() {
        EventCenter.getInstance().addUIObserver(this, "QzDynamicVideo", 1);
    }

    private void Gh(final DynamicArrayList<String> dynamicArrayList, final g gVar) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < dynamicArrayList.size(); i3++) {
            String str = dynamicArrayList.get(i3);
            if (str.startsWith("http:") || str.startsWith("https:")) {
                arrayList.add(Integer.valueOf(i3));
                arrayList2.add(str);
            }
        }
        if (arrayList2.size() == 0) {
            gVar.a(dynamicArrayList);
            return;
        }
        if (!FeedGlobalEnv.g().isNetworkAvailable(null)) {
            ToastUtil.s(getString(R.string.ci5), 4);
            gVar.a(dynamicArrayList);
            return;
        }
        Wh(getString(R.string.gii));
        Dialog dialog = this.L;
        if (dialog != null) {
            dialog.setOnDismissListener(new f(arrayList2, gVar, dynamicArrayList));
        }
        com.qzone.album.env.common.a.m().J(new Runnable() { // from class: com.qzone.album.ui.activity.QzDynamicVideoEditActivity.8

            /* compiled from: P */
            /* renamed from: com.qzone.album.ui.activity.QzDynamicVideoEditActivity$8$a */
            /* loaded from: classes39.dex */
            class a implements u4.f {
                a() {
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void a(String str, ArrayList<String> arrayList) {
                    ArrayList arrayList2 = new ArrayList();
                    if (arrayList2.size() > 0) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            String p16 = QzoneAlbumPicDownloadService.p((String) arrayList2.get(i3));
                            if (!TextUtils.isEmpty(p16)) {
                                arrayList2.add(p16);
                            } else {
                                com.qzone.album.env.common.a.m().b(QzDynamicVideoEditActivity.S, "p2v picDownload - tempPath is null");
                            }
                        }
                    }
                    QzDynamicVideoEditActivity.this.N = false;
                    DynamicArrayList<String> dynamicArrayList = new DynamicArrayList<>();
                    int i16 = 0;
                    for (int i17 = 0; i17 < dynamicArrayList.size(); i17++) {
                        if (i16 < arrayList.size() && i17 == ((Integer) arrayList.get(i16)).intValue() && arrayList2.size() > 0) {
                            dynamicArrayList.add((String) arrayList2.get(i16));
                            i16++;
                        } else {
                            dynamicArrayList.add((String) dynamicArrayList.get(i17));
                        }
                    }
                    QzDynamicVideoEditActivity.this.Fh();
                    gVar.a(dynamicArrayList);
                }

                @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                public void onDownloadFailed(String str) {
                    QzDynamicVideoEditActivity.this.N = false;
                    ToastUtil.s(QzDynamicVideoEditActivity.this.getResources().getString(R.string.gih), 4);
                    QzDynamicVideoEditActivity.this.Fh();
                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                    gVar.a(dynamicArrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QzDynamicVideoEditActivity.this.N = true;
                u4.a.z().t(QzDynamicVideoEditActivity.this.getActivity(), System.currentTimeMillis() + "", arrayList2, new a());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(int i3) {
        this.C.n1(i3 - 1, new Runnable() { // from class: com.qzone.album.ui.activity.QzDynamicVideoEditActivity.5
            @Override // java.lang.Runnable
            public void run() {
                QzDynamicVideoEditActivity.this.Vh();
                QzDynamicVideoEditActivity qzDynamicVideoEditActivity = QzDynamicVideoEditActivity.this;
                qzDynamicVideoEditActivity.Lh(qzDynamicVideoEditActivity.E);
                LpReportInfo_pf00064.allReport(680, 4, 3);
            }
        });
    }

    private ArrayList<SlideItemInfo> Jh(ArrayList<String> arrayList) {
        ArrayList<SlideItemInfo> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return arrayList2;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            String fileName = FileManagerUtil.getFileName(str);
            localMediaInfo.path = str;
            String mimeType = MimeTypesTools.getMimeType(getActivity(), fileName);
            localMediaInfo.mMimeType = mimeType;
            String[] mimeType2 = MimeHelper.getMimeType(mimeType);
            if (MimeHelper.validateVideoType(localMediaInfo.mMimeType)) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                mediaMetadataRetriever.release();
                localMediaInfo.mediaWidth = Integer.parseInt(extractMetadata);
                localMediaInfo.mediaHeight = Integer.parseInt(extractMetadata2);
                localMediaInfo.mDuration = Long.parseLong(extractMetadata3);
                localMediaInfo.position = Integer.valueOf(i3);
                arrayList2.add(new SlideItemInfo(localMediaInfo));
            } else {
                if (mimeType2 != null && "image".equals(mimeType2[0]) && MimeHelper.validateImageType(mimeType2[1])) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    localMediaInfo.mediaWidth = options.outWidth;
                    localMediaInfo.mediaHeight = options.outHeight;
                    localMediaInfo.mDuration = 1500L;
                    localMediaInfo.position = Integer.valueOf(i3);
                    arrayList2.add(new SlideItemInfo(localMediaInfo));
                }
            }
            i3++;
        }
        return arrayList2;
    }

    private void Kh() {
        this.C.setNumColumns(3);
        this.C.setTranscriptMode(1);
        this.C.setLetParentInterceptTouchEventAt23(false);
        this.C.setEditModeEnabled(true);
        this.C.setOnEditModeChangeListener(new a());
        this.C.setOnItemClickListener(new b());
        e9.a aVar = new e9.a(getActivity(), this.C, Integer.MAX_VALUE, -1.0f, 0, true);
        this.D = aVar;
        aVar.t0(this.E);
        this.D.u0(null, null, null, true);
        this.D.notifyDataSetChanged();
        this.D.y0(new c());
        this.C.setAdapter((ListAdapter) this.D);
    }

    private void Mh() {
        Ih();
        Kh();
        Vh();
        this.I.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.Q = com.qzone.common.business.service.b.f();
    }

    private boolean Nh() {
        if (this.E.size() != this.F.size()) {
            return true;
        }
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            if (!this.E.get(i3).equals(this.F.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean Oh(Activity activity) {
        if (activity instanceof QZoneFragmentHolderActivity) {
            return ((QZoneFragmentHolderActivity) activity).Y2(QZoneHelper.PAGE_DYNAMIC_VIDEO_EDIT);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sh() {
        ArrayList<String> arrayList = new ArrayList<>();
        DynamicArrayList<String> dynamicArrayList = this.E;
        if (dynamicArrayList != null) {
            arrayList.addAll(dynamicArrayList);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        LpReportInfo_pf00064.allReport(680, 4, 2);
        return Xh(arrayList, concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        DynamicArrayList<String> dynamicArrayList = this.E;
        if (dynamicArrayList == null || dynamicArrayList.size() <= 0) {
            return;
        }
        this.J.setText(this.D.U() + l.a(R.string.rkt));
    }

    private void Wh(String str) {
        Dialog dialog = this.L;
        if (dialog == null || !dialog.isShowing()) {
            if (this.L == null) {
                ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
                this.L = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.M = (TextView) this.L.findViewById(R.id.dialogText);
                this.L.findViewById(R.id.kja).setVisibility(8);
                this.L.findViewById(R.id.cib).setVisibility(0);
            }
            this.M.setText(str);
            try {
                this.L.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void initData() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        ArrayList<SlideItemInfo> parcelableArrayList = extras.getParcelableArrayList("qzone_slide_show_matters");
        this.H = parcelableArrayList;
        if (parcelableArrayList != null) {
            for (int i3 = 0; i3 < this.H.size(); i3++) {
                this.E.add(this.H.get(i3).f94291i);
                this.F.add(this.H.get(i3).f94291i);
            }
            Lh(this.E);
        }
    }

    public void Fh() {
        try {
            Dialog dialog = this.L;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.L.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean Ph(String str) {
        return FileManagerUtil.getFileType(str) == 2;
    }

    protected void Qh(ArrayList<String> arrayList) {
        this.E.clear();
        if (arrayList != null) {
            this.E.addAll(arrayList);
        }
        Gh(this.E, new e());
    }

    public void Th(ExtendGridView extendGridView, int i3, List<String> list, int i16) {
        if (i3 >= this.E.size()) {
            return;
        }
        this.P = list == null ? 0 : list.size();
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.SELECTED_PATHS", this.E);
        intent.putExtra(PictureConst.KEY_CLASSNAME, getClass().getName());
        intent.putExtra(PictureConst.KEY_SHOW_PROGRESSVIEW, false);
        intent.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, false);
        this.Q.s(getActivity(), extendGridView, i3, this.G, null, i16, intent);
    }

    protected boolean Uh(Activity activity, ArrayList<String> arrayList, int i3, boolean z16, int i16, boolean z17, ConcurrentHashMap<String, String> concurrentHashMap, Bundle bundle) {
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putBoolean("QZONE_SUPPORT_MIX_MOOD", true);
        return this.Q.q(activity, arrayList, null, i3, z16, i16, z17, false, concurrentHashMap, "6", bundle2, QZoneMediaBusiness.QZONE_VIDEO_ALBUM);
    }

    protected boolean Xh(ArrayList<String> arrayList, ConcurrentHashMap<String, String> concurrentHashMap) {
        if (QZLog.isColorLevel()) {
            QZLog.d(S, 2, "maxPhotoCnt=30");
        }
        return Uh(getActivity(), arrayList, 30, false, 3, true, concurrentHashMap, new Bundle());
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        QZLog.d(S, 2, "onActivityResult");
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public void onBackPressed() {
        Intent intent = new Intent();
        new Bundle().putBoolean("key_is_qzone_slide_show_edited", false);
        setResult(-1, intent);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.k5r) {
            LpReportInfo_pf00064.allReport(680, 4, 5);
            onBackPressed();
        } else if (id5 == R.id.agy) {
            LpReportInfo_pf00064.allReport(680, 4, 6);
            Intent intent = new Intent();
            if (!Nh()) {
                intent.putExtra("key_is_qzone_slide_show_edited", false);
            } else {
                intent.putExtra("key_is_qzone_slide_show_edited", true);
                intent.putParcelableArrayListExtra("qzone_slide_show_matters", Jh(this.E));
            }
            setResult(-1, intent);
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        QZLog.d(S, 2, "onNewIntent");
        super.onNewIntent(intent);
        if (intent == null || this.R.a(intent)) {
            return;
        }
        Qh(intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        Eh();
        initData();
        Mh();
        LpReportInfo_pf00064.allReport(680, 4, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements DynamicGridView.t {
        a() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.t
        public void onEditModeChanged(boolean z16) {
            if (z16) {
                if (!QzDynamicVideoEditActivity.this.D.e0()) {
                    QzDynamicVideoEditActivity.this.D.L(true);
                }
                LpReportInfo_pf00064.allReport(680, 4, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int size = arrayList.size();
        ArrayList<PictureItem> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            if (!arrayList.get(i3).startsWith("http")) {
                PictureItem pictureItem = new PictureItem();
                String str = arrayList.get(i3);
                pictureItem.localFileUrl = str;
                pictureItem.isSelected = false;
                if (Ph(str)) {
                    pictureItem.videoflag = 1;
                    VideoInfo videoInfo = new VideoInfo();
                    pictureItem.videodata = videoInfo;
                    videoInfo.videoUrl = new VideoUrl(pictureItem.localFileUrl);
                    pictureItem.videodata.videoTime = ShortVideoUtils.getDurationOfVideo(pictureItem.localFileUrl);
                    VideoInfo videoInfo2 = pictureItem.videodata;
                    videoInfo2.actionType = 3;
                    videoInfo2.playType = (byte) 1;
                    ag.a r16 = ag.r(pictureItem.localFileUrl);
                    if (r16 != null) {
                        pictureItem.videodata.coverUrl = new PictureUrl(r16.f59780a, r16.f59781b, r16.f59782c);
                        VideoInfo videoInfo3 = pictureItem.videodata;
                        videoInfo3.width = r16.f59781b;
                        videoInfo3.height = r16.f59782c;
                    }
                }
                if (o7.b.b(pictureItem.localFileUrl)) {
                    pictureItem.type = 2;
                }
                arrayList2.add(pictureItem);
            }
        }
        this.G = arrayList2;
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        EventSource eventSource;
        if (event == null || (eventSource = event.source) == null || !eventSource.getName().equals("QzDynamicVideo")) {
            return;
        }
        if (event.what != 1) {
            QZLog.e(S, "onEventUIThread - get undefine event, event.what:" + event.what);
            return;
        }
        Object obj = event.params;
        if (obj == null || !(obj instanceof ArrayList)) {
            return;
        }
        try {
            Qh((ArrayList) obj);
        } catch (ClassCastException e16) {
            QZLog.e(S, "onEventUIThread - EVENT_SELECTED_PIC_FROM_NET_ALBUM get an ClassCastException:", e16);
        }
    }

    private void Ih() {
        this.C = (DynamicGridView) findViewById(R.id.d0a);
        this.I = (TextView) findViewById(R.id.k5r);
        this.J = (TextView) findViewById(R.id.k7k);
        this.K = (Button) findViewById(R.id.agy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(localMediaInfo.path);
        Qh(arrayList);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.bgf, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends a.i {
        c() {
        }

        @Override // e9.a.i
        public boolean a() {
            return true;
        }

        @Override // e9.a.i
        public boolean b() {
            QzDynamicVideoEditActivity.this.Sh();
            return true;
        }

        @Override // e9.a.i
        public boolean c(int i3) {
            if (QzDynamicVideoEditActivity.this.D.U() != 1) {
                QzDynamicVideoEditActivity.this.Hh(i3);
                return true;
            }
            ToastUtil.s(QzDynamicVideoEditActivity.this.getString(R.string.gig), 4);
            return true;
        }

        @Override // e9.a.i
        public boolean f(View view) {
            return true;
        }

        @Override // e9.a.i
        public void d() {
        }

        @Override // e9.a.i
        public void e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements xk.a {
        d() {
        }

        @Override // xk.a
        public void a(ArrayList<String> arrayList, List<LocalMediaInfo> list, HashMap<String, PicInfo> hashMap, Intent intent) {
            QzDynamicVideoEditActivity.this.Qh(xk.c.a(list));
        }

        @Override // xk.a
        public void c(LocalMediaInfo localMediaInfo, Intent intent) {
            QzDynamicVideoEditActivity.this.Rh(localMediaInfo);
        }

        @Override // xk.a
        public void d(LocalMediaInfo localMediaInfo, Intent intent) {
            QzDynamicVideoEditActivity.this.Rh(localMediaInfo);
        }

        @Override // xk.a
        public void b() {
        }
    }
}
