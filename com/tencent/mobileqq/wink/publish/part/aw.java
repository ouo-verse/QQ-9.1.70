package com.tencent.mobileqq.wink.publish.part;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.publish.event.PublishChangeTagPanelStateEvent;
import com.tencent.mobileqq.wink.publish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* compiled from: P */
/* loaded from: classes21.dex */
public class aw extends j implements View.OnClickListener {
    public static final String G = UploadConstants.TAG + "PublishMediaPart";
    private FrameLayout C;
    private TextView D;
    private boolean E = false;
    private boolean F = false;

    /* renamed from: d, reason: collision with root package name */
    private PublishViewModel f325818d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f325819e;

    /* renamed from: f, reason: collision with root package name */
    private RoundCornerImageView f325820f;

    /* renamed from: h, reason: collision with root package name */
    private RoundCornerImageView f325821h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f325822i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f325823m;

    public static int F9(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        int i19 = 1;
        if (i17 > i16 || i18 > i3) {
            int i26 = i17 / 2;
            int i27 = i18 / 2;
            while (i26 / i19 > i16 && i27 / i19 > i3) {
                i19 *= 2;
            }
        }
        return i19;
    }

    private void G9() {
        this.f325819e.setVisibility(8);
        this.f325823m.setVisibility(8);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        this.f325820f.setVisibility(8);
        this.f325821h.setVisibility(0);
        this.f325822i.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LocalMediaInfo I9(LocalMediaInfo localMediaInfo) {
        if (TextUtils.isEmpty(localMediaInfo.thumbnailPath)) {
            localMediaInfo.thumbnailPath = PublishVideoUtils.getVideoCover(localMediaInfo.path);
        }
        return localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(ArrayList arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d(G, 1, "[onChanged] mediaInfos: ", arrayList);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) arrayList.get(0);
            if (localMediaInfo == null) {
                QLog.w(G, 1, "[onChanged] invalid firstMediaInfo");
                G9();
                return;
            } else if (AlbumUtil.isVideo(localMediaInfo)) {
                Observable.just(localMediaInfo).map(new Func1() { // from class: com.tencent.mobileqq.wink.publish.part.au
                    @Override // rx.functions.Func1
                    public final Object call(Object obj) {
                        LocalMediaInfo I9;
                        I9 = aw.I9((LocalMediaInfo) obj);
                        return I9;
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.tencent.mobileqq.wink.publish.part.av
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        aw.this.O9((LocalMediaInfo) obj);
                    }
                });
                return;
            } else {
                M9(arrayList, localMediaInfo);
                return;
            }
        }
        QLog.w(G, 1, "[onChanged] invalid mediaInfos");
        G9();
    }

    private void K9() {
        if (this.f325818d == null) {
            this.f325818d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        this.f325818d.C.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                aw.this.J9((ArrayList) obj);
            }
        });
    }

    private void L9() {
        VideoReport.setElementId(this.C, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_COVER_BUTTON);
    }

    private void M9(ArrayList<LocalMediaInfo> arrayList, LocalMediaInfo localMediaInfo) {
        this.F = false;
        if (arrayList.size() > 1) {
            LocalMediaInfo localMediaInfo2 = arrayList.get(1);
            this.f325819e.setVisibility(0);
            N9(localMediaInfo2.path, this.f325819e);
            this.f325823m.setVisibility(8);
            this.C.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setText(String.valueOf(arrayList.size()));
        } else {
            this.f325819e.setVisibility(8);
            this.f325823m.setVisibility(8);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
        }
        this.f325821h.setVisibility(8);
        this.f325822i.setVisibility(8);
        N9(localMediaInfo.path, this.f325820f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9(LocalMediaInfo localMediaInfo) {
        this.F = true;
        N9(localMediaInfo.thumbnailPath, this.f325820f);
        if (this.f325818d.F2(localMediaInfo.path) && this.E && !this.f325818d.x2()) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        this.f325823m.setVisibility(0);
        this.f325821h.setVisibility(8);
        this.f325822i.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return G;
    }

    protected void H9(View view) {
        ((ViewStub) view.findViewById(R.id.f1205279s)).inflate();
        this.f325819e = (RoundCornerImageView) view.findViewById(R.id.f32000sk);
        View findViewById = view.findViewById(R.id.f32030sn);
        this.f325820f = (RoundCornerImageView) view.findViewById(R.id.f32010sl);
        this.f325823m = (ImageView) view.findViewById(R.id.f32090st);
        this.C = (FrameLayout) view.findViewById(R.id.f31940se);
        this.D = (TextView) view.findViewById(R.id.f31970sh);
        this.f325822i = (ImageView) view.findViewById(R.id.f31910sb);
        this.f325821h = (RoundCornerImageView) view.findViewById(R.id.f31990sj);
        int dip2px = ViewUtils.dip2px(4.0f);
        this.f325821h.setCorner(dip2px);
        this.f325819e.setCorner(dip2px);
        this.f325820f.setCorner(dip2px);
        this.f325820f.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f325821h.setOnClickListener(this);
        this.f325822i.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        L9();
    }

    protected void N9(String str, ImageView imageView) {
        QLog.d(G, 1, "setImageView... url:" + str);
        if (!FileUtils.isLocalPath(str)) {
            return;
        }
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int F9 = F9(options, ViewUtils.dip2px(88.0f), ViewUtils.dip2px(120.0f));
        Option option = new Option();
        option.setUrl(str).setTargetView(imageView).setPredecode(true).setRequestWidth(options.outWidth / F9).setRequestHeight(options.outHeight / F9);
        QCircleFeedPicLoader.g().loadImage(option);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.d(G, 1, "onActivityResult... requestCode:", Integer.valueOf(i3), " resultCode:", Integer.valueOf(i16));
        if (i3 == 8 && i16 == -1) {
            this.f325818d.u2(intent);
        }
        this.f325818d.f326001c0 = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.f32010sl && view.getId() != R.id.f31990sj && view.getId() != R.id.f31910sb && view.getId() != R.id.f32030sn) {
            if (view.getId() == R.id.f31940se) {
                if (!FastClickUtils.isFastDoubleClick(G + view.getId())) {
                    if (this.f325818d.y2(getHostFragment())) {
                        this.f325818d.c3(getActivity());
                    } else {
                        QQToast.makeText(getActivity(), getActivity().getString(R.string.f241397rr), 0).show();
                    }
                }
            }
            SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
        } else {
            if (!FastClickUtils.isFastDoubleClick(G + view.getId())) {
                SimpleEventBus.getInstance().dispatchEvent(new PublishChangeTagPanelStateEvent(1));
                SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
                if (this.F) {
                    this.f325818d.e3(getActivity());
                } else {
                    this.f325818d.d3(getActivity(), 0);
                }
                SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.E = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady();
        super.onInitView(view);
        H9(view);
        K9();
    }
}
