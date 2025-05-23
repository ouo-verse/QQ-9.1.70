package com.tencent.state.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.state.square.IShareUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.data.NickCoordinate;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.PosterMotionInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.data.SquarePosterInfo;
import com.tencent.state.square.data.SquarePosterInfoKt;
import com.tencent.state.square.databinding.VasSquareSharePosterBinding;
import com.tencent.state.square.resource.SquareResourceManagerKt;
import com.tencent.state.utils.TimeFormatUtils;
import com.tencent.state.utils.ViewUtils;
import com.tencent.state.view.IAvatarBubble;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\u0017J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/view/VasSquareDetailPosterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareSharePosterBinding;", "bindPosterView", "", "ownerInfo", "Lcom/tencent/state/square/data/SquareAvatarItem;", "multiMotion", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "clearPosterTempFile", "convertToBitMap", "Landroid/graphics/Bitmap;", "getPosterTempFile", MimeHelper.IMAGE_SUBTYPE_BITMAP, "callback", "Lkotlin/Function1;", "Ljava/io/File;", "getUserName", "", "nick", "uin", "locateNickPosition", "view", "Landroid/view/View;", "coordinate", "Lcom/tencent/state/square/data/NickCoordinate;", "updateNickVisible", "isVisible", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareDetailPosterView extends FrameLayout {
    private static final String TAG = "VasSquarePosterView";
    private final VasSquareSharePosterBinding binding;

    public VasSquareDetailPosterView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final String getUserName(String nick, String uin) {
        return nick.length() == 0 ? SquareBaseKt.getSquareCommon().getFriendRemarkName(uin, uin) : nick;
    }

    private final void locateNickPosition(View view, NickCoordinate coordinate) {
        if (SquarePosterInfoKt.isValid(coordinate)) {
            view.setTranslationX(coordinate.getX());
            view.setTranslationY(coordinate.getY());
            view.setVisibility(0);
        }
    }

    public final void clearPosterTempFile() {
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.view.VasSquareDetailPosterView$clearPosterTempFile$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareBaseKt.getSquareLog().i("VasSquarePosterView", "clear poster dir");
                File file = new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), QAdVrReport.ElementID.AD_POSTER);
                if (file.exists()) {
                    file.delete();
                }
            }
        });
    }

    public final Bitmap convertToBitMap() {
        WindowManager windowManager;
        Context context = getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity == null || (windowManager = activity.getWindowManager()) == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        int width = root.getWidth();
        View root2 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        int height = root2.getHeight();
        this.binding.getRoot().measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
        View root3 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
        Bitmap createBitmap = Bitmap.createBitmap(root3.getWidth(), height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        this.binding.getRoot().draw(canvas);
        return createBitmap;
    }

    public final void getPosterTempFile(final Bitmap bitmap, final Function1<? super File, Unit> callback) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        File file = new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), QAdVrReport.ElementID.AD_POSTER);
        if (!file.exists()) {
            file.mkdir();
        }
        final File file2 = new File(file, System.currentTimeMillis() + ".jpg");
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.view.VasSquareDetailPosterView$getPosterTempFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                        fileOutputStream.flush();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } catch (Throwable th5) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquarePosterView", String.valueOf(th5), null, 4, null);
                }
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.VasSquareDetailPosterView$getPosterTempFile$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        VasSquareDetailPosterView$getPosterTempFile$1 vasSquareDetailPosterView$getPosterTempFile$1 = VasSquareDetailPosterView$getPosterTempFile$1.this;
                        callback.invoke(file2);
                    }
                });
            }
        });
    }

    public final void updateNickVisible(boolean isVisible) {
        if (isVisible) {
            TextView textView = this.binding.ownerNick;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.ownerNick");
            textView.setVisibility(0);
            TextView textView2 = this.binding.guestNick;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.guestNick");
            textView2.setVisibility(0);
            return;
        }
        TextView textView3 = this.binding.ownerNick;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.ownerNick");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.guestNick;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.guestNick");
        textView4.setVisibility(8);
    }

    public VasSquareDetailPosterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ VasSquareDetailPosterView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void bindPosterView(SquareAvatarItem ownerInfo, SquareMultiMotionDetailData multiMotion) {
        PosterMotionInfo motionInfo;
        NickCoordinate guestCoordinate;
        PosterMotionInfo motionInfo2;
        NickCoordinate ownerCoordinate;
        PosterMotionInfo motionInfo3;
        PosterMotionInfo motionInfo4;
        Intrinsics.checkNotNullParameter(ownerInfo, "ownerInfo");
        TextView textView = this.binding.name;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.name");
        textView.setText(getUserName(ownerInfo.getNickName(), ownerInfo.getUin()));
        TextView textView2 = this.binding.date;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.date");
        textView2.setText(TimeFormatUtils.INSTANCE.formatCurrentDate());
        OnlineStatus onlineStatus = ownerInfo.getExtra().getOnlineStatus();
        if (onlineStatus != null) {
            onlineStatus.setPublishTimeTips(null);
            IAvatarBubble.DefaultImpls.setData$default(this.binding.avatarBubble, ownerInfo.getUin(), onlineStatus, null, null, ownerInfo.getExtra().getRelationType(), false, true, null, 160, null);
            this.binding.avatarBubble.showCommonView(onlineStatus, true);
            AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble = this.binding.avatarBubble;
            Intrinsics.checkNotNullExpressionValue(avatarOnlineStatusDetailBubble, "binding.avatarBubble");
            avatarOnlineStatusDetailBubble.setVisibility(0);
            PlayerSourceHelper playerSourceHelper = PlayerSourceHelper.INSTANCE;
            SquareImageView squareImageView = this.binding.avatar;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatar");
            Resource resource = SquareResourceManagerKt.getResource(ownerInfo);
            PlayerSourceHelper.setStaticImage$default(playerSourceHelper, squareImageView, resource != null ? SquareItemKt.toMapPlayableSource(resource, Integer.valueOf(ownerInfo.getDefaultResourceId())) : null, null, 4, null);
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            SquarePosterInfo posterInfo = ownerInfo.getExtra().getPosterInfo();
            String background = (posterInfo == null || (motionInfo4 = posterInfo.getMotionInfo()) == null) ? null : motionInfo4.getBackground();
            SquareImageView squareImageView2 = this.binding.background;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.background");
            viewUtils.loadImageDrawable(background, squareImageView2);
            TextView textView3 = this.binding.status;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.status");
            OnlineStatus onlineStatus2 = ownerInfo.getExtra().getOnlineStatus();
            textView3.setText(onlineStatus2 != null ? onlineStatus2.getTitle() : null);
            try {
                SquarePosterInfo posterInfo2 = ownerInfo.getExtra().getPosterInfo();
                this.binding.status.setTextColor(Color.parseColor((posterInfo2 == null || (motionInfo3 = posterInfo2.getMotionInfo()) == null) ? null : motionInfo3.getColor()));
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, String.valueOf(th5), null, 4, null);
            }
            IShareUtils squareShareUtil = SquareBaseKt.getSquareShareUtil();
            SquarePosterInfo posterInfo3 = ownerInfo.getExtra().getPosterInfo();
            Bitmap qrCode = squareShareUtil.getQrCode(posterInfo3 != null ? posterInfo3.getQrCodeUrl() : null, 110, 14);
            if (qrCode != null) {
                this.binding.qrCode.setImageBitmap(qrCode);
            }
            this.binding.stickersBanner.bindData(ownerInfo.getStickers(), true);
        }
        if (multiMotion == null || !multiMotion.isInviteSuccess()) {
            return;
        }
        TextView textView4 = this.binding.ownerNick;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.ownerNick");
        byte[] bArr = multiMotion.getSender().f443329b;
        Intrinsics.checkNotNullExpressionValue(bArr, "multiMotion.sender.nick");
        Charset charset = Charsets.UTF_8;
        textView4.setText(getUserName(new String(bArr, charset), String.valueOf(multiMotion.getSender().f443328a)));
        TextView textView5 = this.binding.guestNick;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.guestNick");
        byte[] bArr2 = multiMotion.getReceiver().f443329b;
        Intrinsics.checkNotNullExpressionValue(bArr2, "multiMotion.receiver.nick");
        textView5.setText(getUserName(new String(bArr2, charset), String.valueOf(multiMotion.getReceiver().f443328a)));
        SquarePosterInfo posterInfo4 = ownerInfo.getExtra().getPosterInfo();
        if (posterInfo4 != null && (motionInfo2 = posterInfo4.getMotionInfo()) != null && (ownerCoordinate = motionInfo2.getOwnerCoordinate()) != null) {
            TextView textView6 = this.binding.ownerNick;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.ownerNick");
            locateNickPosition(textView6, ownerCoordinate);
        }
        SquarePosterInfo posterInfo5 = ownerInfo.getExtra().getPosterInfo();
        if (posterInfo5 == null || (motionInfo = posterInfo5.getMotionInfo()) == null || (guestCoordinate = motionInfo.getGuestCoordinate()) == null) {
            return;
        }
        TextView textView7 = this.binding.guestNick;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.guestNick");
        locateNickPosition(textView7, guestCoordinate);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareDetailPosterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareSharePosterBinding inflate = VasSquareSharePosterBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareSharePosterBind\u2026ater.from(context), this)");
        this.binding = inflate;
    }

    public static /* synthetic */ void bindPosterView$default(VasSquareDetailPosterView vasSquareDetailPosterView, SquareAvatarItem squareAvatarItem, SquareMultiMotionDetailData squareMultiMotionDetailData, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            squareMultiMotionDetailData = null;
        }
        vasSquareDetailPosterView.bindPosterView(squareAvatarItem, squareMultiMotionDetailData);
    }
}
