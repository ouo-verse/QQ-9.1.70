package com.tencent.biz.qqcircle.widgets.person;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.utils.ca;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\n\u001a\u00020\u001f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0010R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalNormalQrcodeView;", "Lcom/tencent/biz/qqcircle/widgets/person/QFSPersonalBaseQrcodeView;", "", "r", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "", "a", h.F, "", "c", "", "G", "Ljava/lang/String;", "TAG", "H", "I", "QRCODE_SIZE", "LOGO_SIZE", "Landroid/widget/FrameLayout;", "J", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/FrameLayout;", "setMFlQrcodeWhiteBg", "(Landroid/widget/FrameLayout;)V", "mFlQrcodeWhiteBg", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "mQrcodeIv", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSPersonalNormalQrcodeView extends QFSPersonalBaseQrcodeView {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: H, reason: from kotlin metadata */
    private final int QRCODE_SIZE;

    /* renamed from: I, reason: from kotlin metadata */
    private final int LOGO_SIZE;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mFlQrcodeWhiteBg;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView mQrcodeIv;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/widgets/person/QFSPersonalNormalQrcodeView$a", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "loadState", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState loadState, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(option, "option");
            if (loadState.isFinishSuccess() && QFSPersonalNormalQrcodeView.this.getMFlQrcode() != null) {
                RoundFrameLayout mFlQrcode = QFSPersonalNormalQrcodeView.this.getMFlQrcode();
                Intrinsics.checkNotNull(mFlQrcode);
                mFlQrcode.setBackground(new BitmapDrawable(option.getResultBitMap()));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/widgets/person/QFSPersonalNormalQrcodeView$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "loadState", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState loadState, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(option, "option");
            if (loadState.isFinishSuccess() && QFSPersonalNormalQrcodeView.this.getMFlQrcodeWhiteBg() != null) {
                FrameLayout mFlQrcodeWhiteBg = QFSPersonalNormalQrcodeView.this.getMFlQrcodeWhiteBg();
                Intrinsics.checkNotNull(mFlQrcodeWhiteBg);
                mFlQrcodeWhiteBg.setBackground(new BitmapDrawable(option.getResultBitMap()));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/widgets/person/QFSPersonalNormalQrcodeView$c", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "loadState", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState loadState, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(option, "option");
            if (loadState.isFinishSuccess()) {
                QCircleShareInfo mShareInfo = QFSPersonalNormalQrcodeView.this.getMShareInfo();
                Intrinsics.checkNotNull(mShareInfo);
                Bitmap d16 = ca.d(mShareInfo.feed.share.shareWebInfo.url.get(), option.getResultBitMap(), QFSPersonalNormalQrcodeView.this.QRCODE_SIZE, QFSPersonalNormalQrcodeView.this.LOGO_SIZE, -16777216, -1);
                ImageView imageView = QFSPersonalNormalQrcodeView.this.mQrcodeIv;
                if (imageView != null) {
                    imageView.setBackground(new BitmapDrawable(d16));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalNormalQrcodeView(@NotNull Context c16, @Nullable AttributeSet attributeSet) {
        super(c16, attributeSet);
        Intrinsics.checkNotNullParameter(c16, "c");
        this.TAG = "QFSPersonaNormalQrcodeView";
        this.QRCODE_SIZE = ViewUtils.dip2px(176.0f);
        this.LOGO_SIZE = ViewUtils.dip2px(22.0f);
    }

    private final boolean r() {
        String obtainTokenToDynamicUrl = QFSDynamicResourceManager.g().obtainTokenToDynamicUrl("qvideo_img_profilepage_qrcode_logo", "");
        if (TextUtils.isEmpty(obtainTokenToDynamicUrl)) {
            return false;
        }
        Option preferDecodeFormat = Option.obtain().setUrl(obtainTokenToDynamicUrl).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        QLog.d(this.TAG, 1, "[handlerQRCodeBackgroundUrl] logo url: " + obtainTokenToDynamicUrl);
        QCircleFeedPicLoader.g().loadImage(preferDecodeFormat, new c());
        return true;
    }

    @Override // com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView
    @SuppressLint({"SetTextI18n"})
    public void a(@Nullable QCircleShareInfo shareInfo) {
        CharSequence charSequence;
        super.a(shareInfo);
        TextView mTvNick = getMTvNick();
        if (mTvNick != null) {
            TextView mTvNick2 = getMTvNick();
            if (mTvNick2 != null) {
                charSequence = mTvNick2.getText();
            } else {
                charSequence = null;
            }
            mTvNick.setText("@" + ((Object) charSequence));
        }
        if (getMFlQrcode() == null) {
            return;
        }
        Option url = Option.obtain().setUrl(QFSDynamicResourceManager.g().obtainTokenToDynamicUrl("qvideo_img_profilepage_qrcode_bottom", ""));
        RoundFrameLayout mFlQrcode = getMFlQrcode();
        Intrinsics.checkNotNull(mFlQrcode);
        Option disableHardwareDecode = url.setRequestWidth(mFlQrcode.getMeasuredWidth()).disableHardwareDecode();
        RoundFrameLayout mFlQrcode2 = getMFlQrcode();
        Intrinsics.checkNotNull(mFlQrcode2);
        QCircleFeedPicLoader.g().loadImage(disableHardwareDecode.setRequestHeight(mFlQrcode2.getMeasuredHeight()), new a());
        Option url2 = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_img_profilepage_qrcode_whitecard"));
        FrameLayout frameLayout = this.mFlQrcodeWhiteBg;
        Intrinsics.checkNotNull(frameLayout);
        Option disableHardwareDecode2 = url2.setRequestWidth(frameLayout.getMeasuredWidth()).disableHardwareDecode();
        FrameLayout frameLayout2 = this.mFlQrcodeWhiteBg;
        Intrinsics.checkNotNull(frameLayout2);
        QCircleFeedPicLoader.g().loadImage(disableHardwareDecode2.setRequestHeight(frameLayout2.getMeasuredHeight()), new b());
        QCircleShareInfo mShareInfo = getMShareInfo();
        Intrinsics.checkNotNull(mShareInfo);
        if (TextUtils.isEmpty(mShareInfo.feed.share.shareWebInfo.url.get())) {
            QLog.d(this.TAG, 1, "[bindData] feed share url is null");
            return;
        }
        if (QFSDynamicResourceManager.g().isDynamicNewNameExp() && r()) {
            return;
        }
        QCircleShareInfo mShareInfo2 = getMShareInfo();
        Intrinsics.checkNotNull(mShareInfo2);
        Bitmap d16 = ca.d(mShareInfo2.feed.share.shareWebInfo.url.get(), BitmapFactory.decodeResource(getResources(), R.drawable.os5), this.QRCODE_SIZE, this.LOGO_SIZE, -16777216, -1);
        ImageView imageView = this.mQrcodeIv;
        if (imageView != null) {
            imageView.setBackground(new BitmapDrawable(d16));
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView
    public int c() {
        return R.layout.gsr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.person.QFSPersonalBaseQrcodeView
    public void h() {
        super.h();
        this.mFlQrcodeWhiteBg = (FrameLayout) findViewById(R.id.f41871i9);
        this.mQrcodeIv = (ImageView) findViewById(R.id.f44541pg);
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final FrameLayout getMFlQrcodeWhiteBg() {
        return this.mFlQrcodeWhiteBg;
    }

    public final void setMFlQrcodeWhiteBg(@Nullable FrameLayout frameLayout) {
        this.mFlQrcodeWhiteBg = frameLayout;
    }
}
