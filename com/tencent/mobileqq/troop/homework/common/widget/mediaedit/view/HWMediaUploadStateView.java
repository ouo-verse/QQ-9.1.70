package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.UploadOrDownloadState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaUploadStateView;", "Landroid/widget/LinearLayout;", "", "message", "", "c", "Lkotlin/Function0;", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "setOnRetryClickListener", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/UploadOrDownloadState;", "uploadState", "", "uploadProgress", "", "compressProgress", "d", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/UploadOrDownloadState;", "currentState", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "progressIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "progressTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWMediaUploadStateView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private UploadOrDownloadState currentState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView progressIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView progressTv;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f296854a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50575);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[UploadOrDownloadState.values().length];
            try {
                iArr[UploadOrDownloadState.DOWNLOAD_SUC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UploadOrDownloadState.UPLOAD_SUC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UploadOrDownloadState.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UploadOrDownloadState.COMPRESSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UploadOrDownloadState.COMPRESS_SUC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UploadOrDownloadState.COMPRESS_ERR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UploadOrDownloadState.UPLOADING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[UploadOrDownloadState.UPLOAD_ERR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[UploadOrDownloadState.DOWNLOADING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[UploadOrDownloadState.DOWNLOAD_ERR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[UploadOrDownloadState.IMG_INVALID_SIZE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[UploadOrDownloadState.VIDEO_INVALID_SIZE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f296854a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWMediaUploadStateView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HWMediaUploadStateView this$0, Function0 retry, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(retry, "$retry");
        UploadOrDownloadState uploadOrDownloadState = this$0.currentState;
        if (uploadOrDownloadState == UploadOrDownloadState.UPLOAD_ERR || uploadOrDownloadState == UploadOrDownloadState.DOWNLOAD_ERR || uploadOrDownloadState == UploadOrDownloadState.COMPRESS_ERR) {
            retry.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void c(String message) {
        setVisibility(0);
        this.progressTv.setText(message);
    }

    public static /* synthetic */ void e(HWMediaUploadStateView hWMediaUploadStateView, UploadOrDownloadState uploadOrDownloadState, float f16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        hWMediaUploadStateView.d(uploadOrDownloadState, f16, i3);
    }

    @SuppressLint({"SetTextI18n"})
    public final void d(@NotNull UploadOrDownloadState uploadState, float uploadProgress, int compressProgress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uploadState, Float.valueOf(uploadProgress), Integer.valueOf(compressProgress));
            return;
        }
        Intrinsics.checkNotNullParameter(uploadState, "uploadState");
        switch (a.f296854a[uploadState.ordinal()]) {
            case 1:
            case 2:
            case 3:
                setVisibility(8);
                break;
            case 4:
                c("\u538b\u7f29\u4e2d " + (compressProgress / 100) + "%");
                break;
            case 5:
                c("\u538b\u7f29\u4e2d 100%");
                break;
            case 6:
                c("\u538b\u7f29\u5931\u8d25\uff0c\u91cd\u8bd5");
                break;
            case 7:
                c("\u4e0a\u4f20\u4e2d " + ((int) (uploadProgress * 100)) + "%");
                break;
            case 8:
                c("\u4e0a\u4f20\u5931\u8d25\uff0c\u91cd\u8bd5");
                break;
            case 9:
                c("\u4e0b\u8f7d\u4e2d " + ((int) (uploadProgress * 100)) + "%");
                break;
            case 10:
                c("\u4e0b\u8f7d\u5931\u8d25\uff0c\u91cd\u8bd5");
                break;
            case 11:
                QQToastUtil.showQQToastInUiThread(1, "\u4e0a\u4f20\u7684\u56fe\u7247\u592a\u5927\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9");
                c("\u8bf7\u91cd\u65b0\u9009\u62e9\u56fe\u7247");
                break;
            case 12:
                QQToastUtil.showQQToastInUiThread(1, "\u4e0a\u4f20\u7684\u89c6\u9891\u592a\u5927\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9");
                c("\u8bf7\u91cd\u65b0\u9009\u62e9\u89c6\u9891");
                break;
        }
        this.currentState = uploadState;
    }

    public final void setOnRetryClickListener(@NotNull final Function0<Unit> retry) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) retry);
        } else {
            Intrinsics.checkNotNullParameter(retry, "retry");
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HWMediaUploadStateView.b(HWMediaUploadStateView.this, retry, view);
                }
            });
        }
    }

    public /* synthetic */ HWMediaUploadStateView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWMediaUploadStateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.currentState = UploadOrDownloadState.IDLE;
        LayoutInflater.from(context).inflate(R.layout.g1c, this);
        setOrientation(1);
        setGravity(17);
        setVisibility(8);
        View findViewById = findViewById(R.id.xwo);
        ImageView imageView = (ImageView) findViewById;
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(context, 1));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView?>\u2026NG_TYPE_WHITE))\n        }");
        this.progressIv = imageView;
        View findViewById2 = findViewById(R.id.xwp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item_progress_tv)");
        this.progressTv = (TextView) findViewById2;
    }
}
