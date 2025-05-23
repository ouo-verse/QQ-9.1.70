package com.qzone.album.business.photolist.ui.header;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.ui.widget.CornerImageView;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneAlbumNoShootTimeHintView extends RelativeLayout {
    private static final int L = u4.a.z().o(5.0f);
    private ImageView C;
    private LocalPhotoLinearGradientView D;
    View.OnClickListener E;
    View.OnClickListener F;
    protected HashMap<Integer, String> G;
    protected List<PhotoCacheData> H;
    int I;
    private String J;
    private View.OnClickListener K;

    /* renamed from: d, reason: collision with root package name */
    private x4.a f43519d;

    /* renamed from: e, reason: collision with root package name */
    private View f43520e;

    /* renamed from: f, reason: collision with root package name */
    private Context f43521f;

    /* renamed from: h, reason: collision with root package name */
    private CornerImageView f43522h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f43523i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f43524m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LpReportInfo_pf00064.allReport(326, 2, 42);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sortOutPhoto", String.valueOf(1));
            com.qzone.album.env.common.a.m().S("noShootTimeReport", hashMap);
            com.qzone.album.env.common.a.m().T(2);
            QzoneAlbumNoShootTimeHintView.this.E.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QzoneAlbumNoShootTimeHintView(Context context) {
        super(context);
        this.I = 0;
        this.J = "";
        this.K = new a();
        a();
    }

    private void a() {
        Context context = this.f43521f;
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.bij, this);
        this.f43520e = inflate;
        this.D = (LocalPhotoLinearGradientView) inflate.findViewById(R.id.haq);
        CornerImageView cornerImageView = (CornerImageView) this.f43520e.findViewById(R.id.hap);
        this.f43522h = cornerImageView;
        cornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        CornerImageView cornerImageView2 = this.f43522h;
        int i3 = L;
        cornerImageView2.setRadius(new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3});
        this.f43523i = (TextView) this.f43520e.findViewById(R.id.hci);
        this.f43524m = (TextView) this.f43520e.findViewById(R.id.hcf);
        ImageView imageView = (ImageView) this.f43520e.findViewById(R.id.hcg);
        this.C = imageView;
        imageView.setOnClickListener(this.F);
        this.D.setShader(new LinearGradient(0.0f, 0.0f, ar.d(160.0f), 0.0f, 16777215, -1, Shader.TileMode.CLAMP));
        this.f43520e.findViewById(R.id.hce).setOnClickListener(this.K);
    }

    public boolean b() {
        List<PhotoCacheData> list = this.H;
        return (list == null || list.size() == 0) ? false : true;
    }

    public void setNums(HashMap<Integer, String> hashMap) {
        TextView textView;
        this.G = hashMap;
        if (hashMap != null && hashMap.get(0) != null) {
            this.I = Integer.parseInt(this.G.get(0));
        }
        if (this.I != 0 && (textView = this.f43523i) != null) {
            textView.setText(this.I + l.a(R.string.rmx));
            return;
        }
        setVisibility(8);
    }

    public void setPhotoData(List<PhotoCacheData> list) {
        PictureUrl pictureUrl;
        if (list != null) {
            com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", "setPhotoData | no shootTime size:", Integer.valueOf(list.size()));
        }
        this.H = list;
        if (list == null || this.f43522h == null || list.size() == 0) {
            return;
        }
        LpReportInfo_pf00064.allReport(326, 2, 41);
        if (this.H.get(0).isVideo()) {
            if (this.H.get(0).videodata != null && this.H.get(0).videodata.currentUrl != null) {
                pictureUrl = this.H.get(0).videodata.currentUrl;
            } else if (this.H.get(0).videodata != null && this.H.get(0).videodata.bigUrl != null) {
                pictureUrl = this.H.get(0).videodata.bigUrl;
            } else {
                pictureUrl = (this.H.get(0).videodata == null || this.H.get(0).videodata.originUrl == null) ? null : this.H.get(0).videodata.originUrl;
            }
            if (pictureUrl != null) {
                this.f43522h.setAsyncImage(pictureUrl.url);
                this.J = pictureUrl.url;
                return;
            }
            return;
        }
        if (this.H.get(0).picItem == null || this.H.get(0).picItem.getPicUrlDec() == null || TextUtils.isEmpty(this.H.get(0).picItem.getPicUrlDec().url)) {
            return;
        }
        this.f43522h.setAsyncImage(this.H.get(0).picItem.getPicUrlDec().url);
        this.J = this.H.get(0).picItem.getPicUrlDec().url;
    }

    public QzoneAlbumNoShootTimeHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 0;
        this.J = "";
        this.K = new a();
        a();
    }

    public QzoneAlbumNoShootTimeHintView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = 0;
        this.J = "";
        this.K = new a();
        a();
    }

    public QzoneAlbumNoShootTimeHintView(Context context, x4.a aVar, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context);
        this.I = 0;
        this.J = "";
        this.K = new a();
        this.f43521f = context;
        this.f43519d = aVar;
        this.E = onClickListener;
        this.F = onClickListener2;
        a();
    }
}
