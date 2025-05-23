package cc;

import aa.e;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.base.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import hb.f;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import nc.bq;
import tl.h;
import ub.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0003H\u0014J(\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u000b2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\bH\u0014R\u0014\u0010'\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00109\u00a8\u0006="}, d2 = {"Lcc/b;", "Lcom/qzone/reborn/base/l;", "Lcb/b;", "Landroid/view/View;", "view", "data", "", "G", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "mediaInfoList", "", HippyTKDListViewAdapter.X, "Lnc/bq;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J", "", "B", BdhLogUtil.LogTag.Tag_Conn, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "", "titleTime", "Lkotlin/Pair;", "y", "", "coverUrl", "H", "", "getViewStubLayoutId", "containerView", "onInitView", "position", "", "payload", "D", "e", "Ljava/lang/String;", "TAG", "", "f", UserInfo.SEX_FEMALE, "LONG_PICTURE_RATIO", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "pic", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvTag", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "curUrl", "I", "picSize", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends l<cb.b> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView pic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvTag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxPicSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float LONG_PICTURE_RATIO = 2.5f;

    /* renamed from: C, reason: from kotlin metadata */
    private String curUrl = "";

    /* renamed from: D, reason: from kotlin metadata */
    private int picSize = z();

    private final bq A() {
        return ((f) q(f.class)).ag();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B() {
        CommonPhotoInfo mediaData;
        CommonStMedia media;
        CommonStImage image;
        CommonPhotoInfo mediaData2 = ((cb.b) this.mData).getMediaData();
        return (e.f(mediaData2 != null ? mediaData2.getMedia() : null) || (mediaData = ((cb.b) this.mData).getMediaData()) == null || (media = mediaData.getMedia()) == null || (image = media.getImage()) == null || !image.getIsGif()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean C() {
        CommonPhotoInfo mediaData = ((cb.b) this.mData).getMediaData();
        if (e.f(mediaData != null ? mediaData.getMedia() : null)) {
            return false;
        }
        CommonPhotoInfo mediaData2 = ((cb.b) this.mData).getMediaData();
        CommonStPicUrl c16 = e.c(mediaData2 != null ? mediaData2.getMedia() : null);
        return c16 != null && ((float) c16.getHeight()) > ((float) c16.getWidth()) * this.LONG_PICTURE_RATIO;
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
        bq A = A();
        String str = (A == null || (dataRepoKey = A.getDataRepoKey()) == null) ? "" : dataRepoKey;
        bq A2 = A();
        List<CommonPhotoInfo> h16 = (A2 == null || (repo = A2.getRepo()) == null) ? null : repo.h();
        bq A3 = A();
        String str2 = (A3 == null || (uin = A3.getUin()) == null) ? "" : uin;
        int x16 = x(h16, data);
        if (x16 == -1) {
            QLog.e(this.TAG, 1, "mediaPos error,mediaPos = -1");
            return;
        }
        hb.e eVar = (hb.e) q(hb.e.class);
        if (eVar != null) {
            view.setTag(R.id.f100755tc, Integer.valueOf(eVar.C5()));
        }
        com.qzone.reborn.albumx.qzonex.utils.h hVar = com.qzone.reborn.albumx.qzonex.utils.h.f53411a;
        Context context = view.getContext();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.ImageView");
        hVar.e(context, h16, (ImageView) view, x16, str2, str, (r17 & 64) != 0 ? false : false);
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
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl);
        ImageView imageView = this.pic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView = null;
        }
        if (imageView.getLayoutParams() != null) {
            ImageView imageView2 = this.pic;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pic");
                imageView2 = null;
            }
            e16.setRequestWidth(imageView2.getLayoutParams().width);
            ImageView imageView3 = this.pic;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pic");
                imageView3 = null;
            }
            e16.setRequestHeight(imageView3.getLayoutParams().height);
        }
        ImageView imageView4 = this.pic;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView4 = null;
        }
        e16.setTargetView(imageView4);
        e16.setLoadingDrawable(p().getResources().getDrawable(R.drawable.at8, null));
        e16.setFailDrawable(p().getResources().getDrawable(R.drawable.at_, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    private final void J() {
        TextView textView = null;
        if (C()) {
            TextView textView2 = this.tvTag;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTag");
                textView2 = null;
            }
            textView2.setText(com.qzone.util.l.a(R.string.rhp));
            TextView textView3 = this.tvTag;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTag");
            } else {
                textView = textView3;
            }
            textView.setVisibility(0);
            return;
        }
        if (B()) {
            TextView textView4 = this.tvTag;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTag");
                textView4 = null;
            }
            textView4.setText(com.qzone.util.l.a(R.string.rhn));
            TextView textView5 = this.tvTag;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTag");
            } else {
                textView = textView5;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView6 = this.tvTag;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTag");
        } else {
            textView = textView6;
        }
        textView.setVisibility(8);
    }

    private final void v() {
        ImageView imageView = this.pic;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.picSize;
        }
        ImageView imageView2 = this.pic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
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
        String e16;
        CommonStMedia media;
        CommonStMedia media2;
        CommonPhotoInfo mediaData = data.getMediaData();
        ImageView imageView = null;
        if (mediaData == null || (media2 = mediaData.getMedia()) == null || (e16 = k9.a.g(media2)) == null) {
            CommonPhotoInfo mediaData2 = data.getMediaData();
            e16 = (mediaData2 == null || (media = mediaData2.getMedia()) == null) ? null : k9.a.e(media, 0, 1, null);
        }
        H(e16);
        Pair<Integer, Integer> y16 = y(data.getCurTimeStamp());
        ImageView imageView2 = this.pic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
        } else {
            imageView = imageView2;
        }
        imageView.setContentDescription(y16.getFirst() + "\u5e74" + y16.getSecond() + "\u6708,\u56fe" + (data.getMediaPos() + 1));
    }

    private final Pair<Integer, Integer> y(long titleTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(titleTime * 1000);
        return new Pair<>(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1));
    }

    private final int z() {
        return (pl.a.f426446a.o(p()) - (ImmersiveUtils.dpToPx(3.0f) * 2)) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(final cb.b data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        v();
        w(data);
        J();
        ImageView imageView = this.pic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pic");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cc.a
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
        View findViewById = containerView.findViewById(R.id.nge);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tab_pic_image)");
        this.pic = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.ngf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tab_tag)");
        this.tvTag = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.ngd);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.tab_pic_container)");
        this.container = (RelativeLayout) findViewById3;
    }

    private final int x(List<CommonPhotoInfo> mediaInfoList, cb.b data) {
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
