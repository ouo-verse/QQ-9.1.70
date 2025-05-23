package gc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.base.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import hb.e;
import hb.f;
import hb.g;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import nc.bp;
import tl.h;
import ub.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003H\u0014J(\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\bH\u0014R\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010$R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00104\u00a8\u00068"}, d2 = {"Lgc/b;", "Lcom/qzone/reborn/base/l;", "Lcb/b;", "Landroid/view/View;", "view", "data", "", "G", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "mediaInfoList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lnc/bp;", BdhLogUtil.LogTag.Tag_Conn, "w", "", "titleTime", "Lkotlin/Pair;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", HippyTKDListViewAdapter.X, "", "coverUrl", "H", "v", "B", "", "getViewStubLayoutId", "containerView", "onInitView", "position", "", "payload", "D", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "coverIV", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "timeTV", "Landroid/widget/RelativeLayout;", "i", "Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curUrl", "I", "picSize", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<cb.b> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView coverIV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView timeTV;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxVideoCoverSection";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String curUrl = "";

    /* renamed from: C, reason: from kotlin metadata */
    private int picSize = B();

    private final Pair<Integer, Integer> A(long titleTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(titleTime * 1000);
        return new Pair<>(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1));
    }

    private final int B() {
        return (pl.a.f426446a.o(p()) - (ImmersiveUtils.dpToPx(3.0f) * 2)) / 3;
    }

    private final bp C() {
        if (q(g.class) == null) {
            return ((f) q(f.class)).ag();
        }
        return ((g) q(g.class)).R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(b this$0, cb.b data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.G(it, data);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void G(View view, cb.b data) {
        String uin;
        p repo;
        String dataRepoKey;
        bp C = C();
        String str = (C == null || (dataRepoKey = C.getDataRepoKey()) == null) ? "" : dataRepoKey;
        bp C2 = C();
        List<CommonPhotoInfo> h16 = (C2 == null || (repo = C2.getRepo()) == null) ? null : repo.h();
        bp C3 = C();
        String str2 = (C3 == null || (uin = C3.getUin()) == null) ? "" : uin;
        int z16 = z(h16, data);
        if (z16 == -1) {
            QLog.e(this.TAG, 1, "mediaPos error,mediaPos = -1");
            return;
        }
        e eVar = (e) q(e.class);
        if (eVar != null) {
            view.setTag(R.id.f100755tc, Integer.valueOf(eVar.C5()));
        }
        com.qzone.reborn.albumx.qzonex.utils.h hVar = com.qzone.reborn.albumx.qzonex.utils.h.f53411a;
        Context context = view.getContext();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.ImageView");
        hVar.e(context, h16, (ImageView) view, z16, str2, str, (r17 & 64) != 0 ? false : false);
    }

    private final void H(String coverUrl) {
        if (TextUtils.isEmpty(coverUrl)) {
            QLog.e(this.TAG, 1, "updateCover error,coverUrl = null");
            return;
        }
        if (Intrinsics.areEqual(this.curUrl, coverUrl)) {
            return;
        }
        Intrinsics.checkNotNull(coverUrl);
        this.curUrl = coverUrl;
        Option e16 = c.e(coverUrl);
        ImageView imageView = this.coverIV;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIV");
            imageView = null;
        }
        if (imageView.getLayoutParams() != null) {
            ImageView imageView2 = this.coverIV;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverIV");
                imageView2 = null;
            }
            e16.setRequestWidth(imageView2.getLayoutParams().width);
            ImageView imageView3 = this.coverIV;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverIV");
                imageView3 = null;
            }
            e16.setRequestHeight(imageView3.getLayoutParams().height);
        }
        ImageView imageView4 = this.coverIV;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIV");
            imageView4 = null;
        }
        e16.setTargetView(imageView4);
        e16.setLoadingDrawable(p().getResources().getDrawable(R.drawable.at8, null));
        e16.setFailDrawable(p().getResources().getDrawable(R.drawable.at_, null));
        c.a().h(e16);
    }

    private final void v() {
        ImageView imageView = this.coverIV;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIV");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.picSize;
        }
        ImageView imageView2 = this.coverIV;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIV");
            imageView2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = this.picSize;
        }
        RelativeLayout relativeLayout2 = this.container;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            relativeLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = relativeLayout2.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = this.picSize;
        }
        RelativeLayout relativeLayout3 = this.container;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            relativeLayout = relativeLayout3;
        }
        ViewGroup.LayoutParams layoutParams4 = relativeLayout.getLayoutParams();
        if (layoutParams4 == null) {
            return;
        }
        layoutParams4.height = this.picSize;
    }

    private final void w(cb.b data) {
        Pair<Integer, Integer> A = A(data.getCurTimeStamp());
        ImageView imageView = this.coverIV;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIV");
            imageView = null;
        }
        imageView.setContentDescription(A.getFirst() + "\u5e74" + A.getSecond() + "\u6708,\u56fe" + (data.getMediaPos() + 1));
    }

    private final void x(cb.b data) {
        String str;
        CommonStMedia media;
        CommonStMedia media2;
        CommonPhotoInfo mediaData = data.getMediaData();
        if (mediaData == null || (media2 = mediaData.getMedia()) == null || (str = k9.a.g(media2)) == null) {
            CommonPhotoInfo mediaData2 = data.getMediaData();
            if (mediaData2 != null && (media = mediaData2.getMedia()) != null) {
                str = k9.a.e(media, 0, 1, null);
            } else {
                str = "";
            }
        }
        H(str);
    }

    private final void y(cb.b data) {
        CommonStMedia media;
        CommonStVideo video;
        CommonPhotoInfo mediaData = data.getMediaData();
        String d16 = nh.c.d((mediaData == null || (media = mediaData.getMedia()) == null || (video = media.getVideo()) == null) ? 0 : (int) video.getVideoTime());
        TextView textView = this.timeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeTV");
            textView = null;
        }
        textView.setText(d16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(final cb.b data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        v();
        y(data);
        x(data);
        w(data);
        ImageView imageView = this.coverIV;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverIV");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: gc.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.F(b.this, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.ngi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tab_video_image)");
        this.coverIV = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.ngj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tab_video_time)");
        this.timeTV = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.ngh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026R.id.tab_video_container)");
        this.container = (RelativeLayout) findViewById3;
    }

    private final int z(List<CommonPhotoInfo> mediaInfoList, cb.b data) {
        List<CommonPhotoInfo> list = mediaInfoList;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = mediaInfoList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(mediaInfoList.get(i3), data.getMediaData())) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
