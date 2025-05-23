package com.qzone.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneAlbumVideoControlView extends IndividualAutoVideoControlView {
    private ImageButton V;
    private View.OnClickListener W;

    /* renamed from: a0, reason: collision with root package name */
    private SeekBar.OnSeekBarChangeListener f49682a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            ((IndividualAutoVideoControlView) QzoneAlbumVideoControlView.this).T.onProgressChanged(seekBar, i3, z16);
            QzoneAlbumVideoControlView.y(QzoneAlbumVideoControlView.this);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            ((IndividualAutoVideoControlView) QzoneAlbumVideoControlView.this).T.onStartTrackingTouch(seekBar);
            QzoneAlbumVideoControlView.y(QzoneAlbumVideoControlView.this);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            ((IndividualAutoVideoControlView) QzoneAlbumVideoControlView.this).T.onStopTrackingTouch(seekBar);
            QzoneAlbumVideoControlView.y(QzoneAlbumVideoControlView.this);
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
    }

    public QzoneAlbumVideoControlView(Context context, PlayerResources playerResources) {
        super(context, playerResources);
        E();
    }

    static /* bridge */ /* synthetic */ b y(QzoneAlbumVideoControlView qzoneAlbumVideoControlView) {
        qzoneAlbumVideoControlView.getClass();
        return null;
    }

    public void C(View.OnClickListener onClickListener) {
        this.W = onClickListener;
    }

    public ImageButton D() {
        return this.V;
    }

    public void E() {
        this.f49682a0 = new a();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView
    public void k() {
        super.k();
        u(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView
    public void l(View view) {
        super.l(view);
        ProgressBar progressBar = this.f279818h;
        if (progressBar instanceof SeekBar) {
            ((SeekBar) progressBar).setOnSeekBarChangeListener(this.f49682a0);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView
    protected View q() {
        View inflate = ((LayoutInflater) this.f279816e.getSystemService("layout_inflater")).inflate(this.M.getLayoutId(8), (ViewGroup) null);
        this.f279817f = inflate;
        ImageButton imageButton = (ImageButton) inflate.findViewById(this.M.getViewId(578));
        this.V = imageButton;
        View.OnClickListener onClickListener = this.W;
        if (onClickListener != null) {
            imageButton.setOnClickListener(onClickListener);
        }
        l(this.f279817f);
        return this.f279817f;
    }

    public void setOnSeekBarChangeListener(b bVar) {
    }
}
