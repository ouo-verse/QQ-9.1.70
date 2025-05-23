package com.tencent.biz.qqcircle.widgets.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.utils.e;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StShareURLInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalAigcQrcodeView;", "Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalBaseQrcodeView;", "", h.F, "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "a", "", "url", "setQrcodeBackground", "Landroid/graphics/Bitmap;", "g", "", "c", "G", "Ljava/lang/String;", "TAG", "H", "Landroid/graphics/Bitmap;", "mBarBitmap", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSPersonalAigcQrcodeView extends QFSPersonalBaseQrcodeView {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Bitmap mBarBitmap;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/widgets/person/QFSPersonalAigcQrcodeView$a", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "loadState", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState loadState, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(option, "option");
            if (loadState.isFinishSuccess()) {
                QFSPersonalAigcQrcodeView.this.mBarBitmap = option.getResultBitMap();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/widgets/person/QFSPersonalAigcQrcodeView$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "loadState", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState loadState, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(option, "option");
            if (loadState.isFinishSuccess() && QFSPersonalAigcQrcodeView.this.getMFlQrcode() != null) {
                RoundFrameLayout mFlQrcode = QFSPersonalAigcQrcodeView.this.getMFlQrcode();
                Intrinsics.checkNotNull(mFlQrcode);
                mFlQrcode.setBackground(new BitmapDrawable(option.getResultBitMap()));
                RoundFrameLayout mFlQrcode2 = QFSPersonalAigcQrcodeView.this.getMFlQrcode();
                if (mFlQrcode2 != null) {
                    mFlQrcode2.setVisibility(0);
                    return;
                }
                return;
            }
            QLog.d(QFSPersonalAigcQrcodeView.this.TAG, 1, "mFlQrcode loadImage is fail");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalAigcQrcodeView(@NotNull Context c16, @Nullable AttributeSet attributeSet) {
        super(c16, attributeSet);
        Intrinsics.checkNotNullParameter(c16, "c");
        this.TAG = "QFSPersonalAigcQrcodeView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView
    public void a(@Nullable QCircleShareInfo shareInfo) {
        FeedCloudMeta$StShareURLInfo feedCloudMeta$StShareURLInfo;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StShare feedCloudMeta$StShare;
        PBRepeatMessageField<FeedCloudMeta$StShareURLInfo> pBRepeatMessageField;
        List<FeedCloudMeta$StShareURLInfo> list;
        Object obj;
        boolean z16;
        super.a(shareInfo);
        String str = null;
        if (shareInfo != null && (feedCloudMeta$StFeed = shareInfo.feed) != null && (feedCloudMeta$StShare = feedCloudMeta$StFeed.share) != null && (pBRepeatMessageField = feedCloudMeta$StShare.url_infos) != null && (list = pBRepeatMessageField.get()) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((FeedCloudMeta$StShareURLInfo) obj).type.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            feedCloudMeta$StShareURLInfo = (FeedCloudMeta$StShareURLInfo) obj;
        } else {
            feedCloudMeta$StShareURLInfo = null;
        }
        if (feedCloudMeta$StShareURLInfo != null && (pBStringField = feedCloudMeta$StShareURLInfo.url) != null) {
            str = pBStringField.get();
        }
        setQrcodeBackground(str);
    }

    @Override // com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView
    public int c() {
        return R.layout.gsp;
    }

    @Override // com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView
    @Nullable
    protected Bitmap g() {
        boolean z16;
        if (getMFlQrcode() == null) {
            return null;
        }
        RoundFrameLayout mFlQrcode = getMFlQrcode();
        Intrinsics.checkNotNull(mFlQrcode);
        Bitmap b16 = e.b(mFlQrcode);
        Bitmap bitmap = this.mBarBitmap;
        if (bitmap != null) {
            if (bitmap != null && bitmap.getHeight() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b16, 512, 768, false);
                b16.recycle();
                Bitmap bitmap2 = this.mBarBitmap;
                Intrinsics.checkNotNull(bitmap2);
                return e.a(createScaledBitmap, Bitmap.createScaledBitmap(bitmap2, 512, 102, true));
            }
            return b16;
        }
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView
    public void h() {
        super.h();
    }

    public final void setQrcodeBackground(@Nullable String url) {
        if (getMFlQrcode() != null && !TextUtils.isEmpty(url)) {
            RoundFrameLayout mFlQrcode = getMFlQrcode();
            if (mFlQrcode != null) {
                mFlQrcode.setVisibility(8);
            }
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_bar_aigc_qrcode")).disableHardwareDecode(), new a());
            Option url2 = Option.obtain().setUrl(url);
            RoundFrameLayout mFlQrcode2 = getMFlQrcode();
            Intrinsics.checkNotNull(mFlQrcode2);
            Option disableHardwareDecode = url2.setRequestWidth(mFlQrcode2.getMeasuredWidth()).disableHardwareDecode();
            RoundFrameLayout mFlQrcode3 = getMFlQrcode();
            Intrinsics.checkNotNull(mFlQrcode3);
            QCircleFeedPicLoader.g().loadImage(disableHardwareDecode.setRequestHeight(mFlQrcode3.getMeasuredHeight()), new b());
        }
    }
}
