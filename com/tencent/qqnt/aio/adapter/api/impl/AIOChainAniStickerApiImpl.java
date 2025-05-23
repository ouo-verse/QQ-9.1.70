package com.tencent.qqnt.aio.adapter.api.impl;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.common.app.AppInterface;
import com.tencent.imsdk.BaseConstants;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.bf.l0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qqfavor.api.IQQFavHelper;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.adapter.api.IAIOChainAniStickerApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u0002:;B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J;\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J0\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J0\u0010 \u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J \u0010$\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010)\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010+\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\fH\u0016R0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0-j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOChainAniStickerApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOChainAniStickerApi;", "", "serverId", "", "getPicUrl", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "picUrl", "reportChatType", "", "preparePicAndShow", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "originPath", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "compositeImage", "Landroid/graphics/Canvas;", PM.CANVAS, "drawAvatar", "drawAvatarWithAsyncGet", "getFormatNickname", "path", MimeHelper.IMAGE_SUBTYPE_BITMAP, "showShareActionSheet", "reportNoActionCancel", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetWithPreview;", "shareActionSheet", "setActionSheetContent", "preView", "setShareActionSheetClickListener", "forwardToFriend", "forwardToFriendInner1", "forwardToFriendInner2", "shareToQZone", "", "toWeChatCircle", "shareToWeChat", l0.NAME, "addToFavorite", "preDownloadPic", "showSharePage", "hideSharePage", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/aio/adapter/api/impl/AIOChainAniStickerApiImpl$b;", "Lkotlin/collections/HashMap;", "serverId2DrawParam", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "shareActionSheetRef", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "prepareToShare", "Z", "<init>", "()V", "Companion", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOChainAniStickerApiImpl implements IAIOChainAniStickerApi {
    private static final int AVATAR_SIZE = 56;
    private static final String CHAIN_ANI_STICKER_GET_AVATAR_ASYNC = "chain_ani_sticker_get_avatar_async_130364323";
    private static final String CHAIN_ANI_STICKER_SHARE = "103164";
    private static final float MAIN_TEXT_SIZE = 40.0f;
    private static final int NATIONAL_DAY_SERVER_ID = 421;
    private static final String QZONE_SHARE_VALUE_APPID = "qzevent_33";
    private static final String QZONE_SHARE_VALUE_URL = "https://ti.qq.com/qq-act/qq-jielong-emoji202410/index.html?_wwv=8192&_wv=16777216";
    private static final String TAG = "AIOChainAniStickerApiImpl";
    private boolean prepareToShare;
    private final HashMap<Integer, DrawParam> serverId2DrawParam;
    private com.tencent.qqnt.avatar.meta.refresh.c<ShareActionSheetWithPreview> shareActionSheetRef;
    private static final PointF avatarPoint = new PointF(48.0f, 1353.0f);
    private static final PointF nickPoint = new PointF(112.0f, 1381.0f);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f348521a;

        static {
            int[] iArr = new int[LoadState.values().length];
            try {
                iArr[LoadState.STATE_DOWNLOAD_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadState.STATE_DOWNLOAD_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f348521a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOChainAniStickerApiImpl$d", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView$b;", "", "onLoadFinish", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements QQProAvatarView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f348522a;

        d(Object obj) {
            this.f348522a = obj;
        }

        @Override // com.tencent.mobileqq.proavatar.QQProAvatarView.b
        public void onLoadFinish() {
            QLog.i(AIOChainAniStickerApiImpl.TAG, 1, "compositeImage  notify");
            Object obj = this.f348522a;
            synchronized (obj) {
                try {
                    try {
                        obj.notify();
                    } catch (Exception e16) {
                        QLog.i(AIOChainAniStickerApiImpl.TAG, 1, "onLoadFinish e:" + e16);
                    }
                } catch (InterruptedException e17) {
                    e17.printStackTrace();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOChainAniStickerApiImpl$e", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f348523a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f348524b;

        e(Activity activity, String str) {
            this.f348523a = activity;
            this.f348524b = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            AIOGalleryUtils.q(this.f348523a, this.f348524b, null);
        }
    }

    public AIOChainAniStickerApiImpl() {
        HashMap<Integer, DrawParam> hashMap = new HashMap<>();
        this.serverId2DrawParam = hashMap;
        hashMap.put(417, new DrawParam("https://downv6.qq.com/qqface/dwjlfx.png", -16741004));
        hashMap.put(421, new DrawParam("https://downv6.qq.com/qqface/gqjlfx.png", -15066082));
        hashMap.put(431, new DrawParam("https://downv6.qq.com/qqface/sncj.png", -15066082));
    }

    private final void addToFavorite(Activity activity, String path) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IQQFavHelper) peekAppRuntime.getRuntimeService(IQQFavHelper.class, "all")).addPictureToFavorite(peekAppRuntime, activity, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, Bitmap> compositeImage(Activity activity, String originPath, int serverId) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!FileUtils.fileExists(originPath)) {
            return null;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_EMOTICON_PATH);
        Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "getSDKPrivatePath(AppCon\u2026nts.SDCARD_EMOTICON_PATH)");
        File file = new File(sDKPrivatePath);
        if (!file.exists() && !file.mkdirs()) {
            QLog.i(TAG, 1, "compositeImage create dir failed");
            return null;
        }
        File file2 = new File(sDKPrivatePath, "chain_ani_sticker_poster_" + System.currentTimeMillis() + ".jpg");
        Bitmap decodeFile = BitmapFactory.decodeFile(originPath);
        if (decodeFile == null) {
            QLog.e(TAG, 1, "generateCompositeImage originBitmap is null, originPath:" + originPath);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            QLog.e(TAG, 1, "compositeImage safeCreateBitmap error fileName:" + file2.getName());
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
        drawAvatar(activity, canvas);
        Paint paint = new Paint(1);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        DrawParam drawParam = this.serverId2DrawParam.get(Integer.valueOf(serverId));
        paint.setColor(drawParam != null ? drawParam.getColor() : -15066082);
        paint.setTextSize(40.0f);
        String formatNickname = getFormatNickname();
        PointF pointF = nickPoint;
        canvas.drawText(formatNickname, pointF.x, pointF.y - ((paint.getFontMetrics().ascent + paint.getFontMetrics().descent) / 2.0f), paint);
        if (FileUtils.saveBitmapToFile(createBitmap, file2.getAbsolutePath(), 100)) {
            QLog.i(TAG, 1, "compositeImage fileName:" + file2.getName() + ", take time:" + (System.currentTimeMillis() - currentTimeMillis));
            String absolutePath = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "generatedFile.absolutePath");
            return new Pair<>(absolutePath, createBitmap);
        }
        QLog.i(TAG, 1, "compositeImage saveBitmapToFile failed, fileName:" + file2.getName());
        return null;
    }

    private final void drawAvatar(Activity activity, Canvas canvas) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            Bitmap faceBitmap = ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getFaceBitmap(1, appInterface.getCurrentUin(), (byte) 3, 140);
            if (faceBitmap == null) {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CHAIN_ANI_STICKER_GET_AVATAR_ASYNC, true);
                QLog.i(TAG, 1, "compositeImage  originFaceBitmap is null, getAvatarAsync:" + isSwitchOn);
                if (isSwitchOn) {
                    drawAvatarWithAsyncGet(activity, canvas);
                    return;
                }
                return;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(0.4f, 0.4f);
            Bitmap createBitmap = Bitmap.createBitmap(faceBitmap, 0, 0, faceBitmap.getWidth(), faceBitmap.getHeight(), matrix, true);
            QLog.i(TAG, 1, "compositeImage  scaleBitmap:" + createBitmap);
            PointF pointF = avatarPoint;
            canvas.drawBitmap(createBitmap, pointF.x, pointF.y, (Paint) null);
        }
    }

    private final void drawAvatarWithAsyncGet(Activity activity, Canvas canvas) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            Object obj = new Object();
            QQProAvatarView qQProAvatarView = new QQProAvatarView(activity, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            qQProAvatarView.w(1, appInterface.getCurrentUin());
            qQProAvatarView.i(new d(obj));
            QLog.i(TAG, 1, "compositeImage  wait");
            synchronized (obj) {
                try {
                    obj.wait(3000L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                Unit unit = Unit.INSTANCE;
            }
            QLog.i(TAG, 1, "compositeImage  avatar is ready");
            Drawable drawable = qQProAvatarView.s().getDrawable();
            if (drawable != null) {
                PointF pointF = avatarPoint;
                float f16 = pointF.x;
                float f17 = pointF.y;
                drawable.setBounds((int) f16, (int) f17, ((int) f16) + 56, ((int) f17) + 56);
                drawable.draw(canvas);
                QLog.i(TAG, 1, "compositeImage  avatarDrawable:" + drawable);
                return;
            }
            QLog.i(TAG, 1, "compositeImage  avatarDrawable is null");
        }
    }

    private final void forwardToFriend(Activity activity, String path) {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chain_ani_sticker_forward_to_friend_130916059", true);
        QLog.i(TAG, 1, "forwardToFriend  isSwitchOn:" + isSwitchOn);
        if (isSwitchOn) {
            forwardToFriendInner1(activity, path);
        } else {
            forwardToFriendInner2(activity, path);
        }
    }

    private final void forwardToFriendInner1(Activity activity, String path) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, path);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, path);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, path);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, path);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(activity, intent, 21);
    }

    private final void forwardToFriendInner2(Activity activity, String path) {
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtras(new Bundle());
        intent.putExtra("forward_type", 1);
        intent.setData(Uri.parse(path));
        activity.startActivityForResult(intent, COMM.oidb_proxy_svr);
    }

    private final String getFormatNickname() {
        ArrayList<String> arrayListOf;
        String str;
        String uid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uid);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf, TAG);
        String str2 = "";
        if (friendSimpleInfoWithUid != null) {
            loop0: while (true) {
                str = "";
                for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : friendSimpleInfoWithUid) {
                    if (!Intrinsics.areEqual(dVar.getUid(), uid) || (str = dVar.p()) != null) {
                    }
                }
            }
            str2 = str;
        }
        StringBuilder sb5 = new StringBuilder();
        int length = str2.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str2.charAt(i16);
            byte[] bytes = String.valueOf(charAt).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            i3 += bytes.length == 1 ? 1 : 2;
            if (i3 > 16) {
                break;
            }
            sb5.append(charAt);
        }
        if (sb5.length() >= str2.length()) {
            return str2;
        }
        return ((Object) sb5) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    private final String getPicUrl(int serverId) {
        String picUrl;
        DrawParam drawParam = this.serverId2DrawParam.get(Integer.valueOf(serverId));
        return (drawParam == null || (picUrl = drawParam.getPicUrl()) == null) ? "" : picUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preDownloadPic$lambda$1(AIOChainAniStickerApiImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            ((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getFaceBitmap(1, appInterface.getCurrentUin(), (byte) 3, 140);
        }
        String picUrl = this$0.getPicUrl(i3);
        if (picUrl.length() == 0) {
            return;
        }
        Option url = Option.obtain().setUrl(picUrl);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        if (FileUtils.fileExists(qQPicLoader.d().getPicLocalPath(url))) {
            return;
        }
        QLog.i(TAG, 1, "preDownloadPic  picUrl:" + picUrl);
        qQPicLoader.d().download(url, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preparePicAndShow$lambda$2(CoroutineScope mainScope, Ref.ObjectRef result, String str, AIOChainAniStickerApiImpl this$0, Activity activity, int i3, int i16, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(mainScope, "$mainScope");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        int i17 = loadState == null ? -1 : c.f348521a[loadState.ordinal()];
        if (i17 == 1) {
            BuildersKt__Builders_commonKt.launch$default(mainScope, null, null, new AIOChainAniStickerApiImpl$preparePicAndShow$3$1(result, str, this$0, activity, i3, i16, null), 3, null);
        } else {
            if (i17 != 2) {
                return;
            }
            QLog.e(TAG, 1, "preparePicAndShow download failed, option:" + option);
        }
    }

    private final void saveFile(Activity activity, String path) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_EMOTICON, QQPermissionConstants.Business.SCENE.EMOTICON_SHARE_CARD));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            AIOGalleryUtils.q(activity, path, null);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new e(activity, path));
        }
    }

    private final void setActionSheetContent(ShareActionSheetWithPreview shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build);
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build2);
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
        arrayList.add(build3);
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
        arrayList.add(build4);
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build5);
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(6);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026tem.ACTION_ADD_FAVORITER)");
        arrayList2.add(build6);
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
    }

    private final void setShareActionSheetClickListener(final Activity activity, ShareActionSheetWithPreview shareActionSheet, final Bitmap preView, final String path, final int serverId) {
        shareActionSheet.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.e
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet2) {
                AIOChainAniStickerApiImpl.setShareActionSheetClickListener$lambda$12(AIOChainAniStickerApiImpl.this, activity, path, serverId, preView, actionSheetItem, shareActionSheet2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setShareActionSheetClickListener$lambda$12(AIOChainAniStickerApiImpl this$0, Activity activity, String path, int i3, Bitmap preView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(preView, "$preView");
        shareActionSheet.dismiss();
        int i16 = actionSheetItem.action;
        if (i16 == 2) {
            this$0.forwardToFriend(activity, path);
            return;
        }
        if (i16 == 3) {
            this$0.shareToQZone(activity, path, i3);
            return;
        }
        if (i16 == 6) {
            this$0.addToFavorite(activity, path);
            return;
        }
        if (i16 == 39) {
            this$0.saveFile(activity, path);
        } else if (i16 == 9) {
            this$0.shareToWeChat(false, preView, path);
        } else {
            if (i16 != 10) {
                return;
            }
            this$0.shareToWeChat(true, preView, path);
        }
    }

    private final void shareToQZone(Activity activity, String path, int serverId) {
        ArrayList<String> arrayListOf;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            Bundle bundle = new Bundle();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(path);
            bundle.putStringArrayList("images", arrayListOf);
            if (serverId == 421) {
                QLog.i(TAG, 1, "shareToQZone add national third party info");
                bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, QZONE_SHARE_VALUE_APPID);
                bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, QZONE_SHARE_VALUE_URL);
            }
            QZoneShareManager.publishToQzone(appInterface, activity, bundle, null, BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT);
        }
    }

    private final void shareToWeChat(boolean toWeChatCircle, Bitmap preView, String path) {
        if (!WXShareHelper.b0().e0()) {
            QLog.e(TAG, 1, "shareToWeChat failed, wx not installed");
            QQToastUtil.showQQToast(1, R.string.f173257ih1);
        } else if (!WXShareHelper.b0().f0()) {
            QLog.e(TAG, 1, "shareToWeChat failed, wx version too low");
            QQToastUtil.showQQToast(1, R.string.f173258ih2);
        } else {
            WXShareHelper.b0().w0(path, preView, toWeChatCircle ? 1 : 0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showShareActionSheet$lambda$11$lambda$10(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.getIntent().putExtra("big_brother_source_key", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showShareActionSheet$lambda$11$lambda$8(AIOChainAniStickerApiImpl this$0, int i3, int i16, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reportNoActionCancel(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showShareActionSheet$lambda$11$lambda$9(AIOChainAniStickerApiImpl this$0, int i3, int i16, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reportNoActionCancel(i3, i16);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChainAniStickerApi
    public void preDownloadPic(final int serverId) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CHAIN_ANI_STICKER_SHARE, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOChainAniStickerApiImpl.preDownloadPic$lambda$1(AIOChainAniStickerApiImpl.this, serverId);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChainAniStickerApi
    public void showSharePage(Activity activity, int serverId, int reportChatType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CHAIN_ANI_STICKER_SHARE, true);
        QLog.i(TAG, 1, "showSharePage  serverId:" + serverId + ", isSwitchOn:" + isSwitchOn);
        if (isSwitchOn) {
            this.prepareToShare = true;
            String picUrl = getPicUrl(serverId);
            if (picUrl.length() == 0) {
                return;
            }
            CoroutineScope MainScope = CoroutineScopeKt.MainScope();
            BuildersKt__Builders_commonKt.launch$default(MainScope, null, null, new AIOChainAniStickerApiImpl$showSharePage$1(this, activity, MainScope, serverId, picUrl, reportChatType, null), 3, null);
        }
    }

    private final void reportNoActionCancel(int serverId, int reportChatType) {
        ReportController.o(null, "dc00898", "", "", "0X800C66A", "0X800C66A", 0, 0, String.valueOf(reportChatType), String.valueOf(serverId), "", "");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOChainAniStickerApi
    public void hideSharePage() {
        ShareActionSheetWithPreview shareActionSheetWithPreview;
        QLog.i(TAG, 1, "hideSharePage");
        this.prepareToShare = false;
        com.tencent.qqnt.avatar.meta.refresh.c<ShareActionSheetWithPreview> cVar = this.shareActionSheetRef;
        if (cVar == null || (shareActionSheetWithPreview = cVar.get()) == null) {
            return;
        }
        shareActionSheetWithPreview.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOChainAniStickerApiImpl$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "picUrl", "I", "()I", "color", "<init>", "(Ljava/lang/String;I)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOChainAniStickerApiImpl$b, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class DrawParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String picUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int color;

        public DrawParam(String picUrl, int i3) {
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            this.picUrl = picUrl;
            this.color = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: b, reason: from getter */
        public final String getPicUrl() {
            return this.picUrl;
        }

        public int hashCode() {
            return (this.picUrl.hashCode() * 31) + this.color;
        }

        public String toString() {
            return "DrawParam(picUrl=" + this.picUrl + ", color=" + this.color + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DrawParam)) {
                return false;
            }
            DrawParam drawParam = (DrawParam) other;
            return Intrinsics.areEqual(this.picUrl, drawParam.picUrl) && this.color == drawParam.color;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object preparePicAndShow(Activity activity, CoroutineScope coroutineScope, int i3, String str, int i16, Continuation<? super Unit> continuation) {
        AIOChainAniStickerApiImpl$preparePicAndShow$1 aIOChainAniStickerApiImpl$preparePicAndShow$1;
        Object coroutine_suspended;
        int i17;
        String picLocalPath;
        Ref.ObjectRef objectRef;
        final Activity activity2;
        final CoroutineScope coroutineScope2;
        final int i18;
        final int i19;
        final AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl;
        Option option;
        Ref.BooleanRef booleanRef;
        if (continuation instanceof AIOChainAniStickerApiImpl$preparePicAndShow$1) {
            aIOChainAniStickerApiImpl$preparePicAndShow$1 = (AIOChainAniStickerApiImpl$preparePicAndShow$1) continuation;
            int i26 = aIOChainAniStickerApiImpl$preparePicAndShow$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                aIOChainAniStickerApiImpl$preparePicAndShow$1.label = i26 - Integer.MIN_VALUE;
                AIOChainAniStickerApiImpl$preparePicAndShow$1 aIOChainAniStickerApiImpl$preparePicAndShow$12 = aIOChainAniStickerApiImpl$preparePicAndShow$1;
                Object obj = aIOChainAniStickerApiImpl$preparePicAndShow$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = aIOChainAniStickerApiImpl$preparePicAndShow$12.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Option url = Option.obtain().setUrl(str);
                    picLocalPath = QQPicLoader.f201806a.d().getPicLocalPath(url);
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    objectRef = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    AIOChainAniStickerApiImpl$preparePicAndShow$2 aIOChainAniStickerApiImpl$preparePicAndShow$2 = new AIOChainAniStickerApiImpl$preparePicAndShow$2(booleanRef2, picLocalPath, objectRef, this, activity, i3, null);
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.L$0 = this;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.L$1 = activity;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.L$2 = coroutineScope;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.L$3 = url;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.L$4 = picLocalPath;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.L$5 = booleanRef2;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.L$6 = objectRef;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.I$0 = i3;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.I$1 = i16;
                    aIOChainAniStickerApiImpl$preparePicAndShow$12.label = 1;
                    if (BuildersKt.withContext(io5, aIOChainAniStickerApiImpl$preparePicAndShow$2, aIOChainAniStickerApiImpl$preparePicAndShow$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    activity2 = activity;
                    coroutineScope2 = coroutineScope;
                    i18 = i3;
                    i19 = i16;
                    aIOChainAniStickerApiImpl = this;
                    option = url;
                    booleanRef = booleanRef2;
                } else if (i17 == 1) {
                    int i27 = aIOChainAniStickerApiImpl$preparePicAndShow$12.I$1;
                    int i28 = aIOChainAniStickerApiImpl$preparePicAndShow$12.I$0;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) aIOChainAniStickerApiImpl$preparePicAndShow$12.L$6;
                    booleanRef = (Ref.BooleanRef) aIOChainAniStickerApiImpl$preparePicAndShow$12.L$5;
                    String str2 = (String) aIOChainAniStickerApiImpl$preparePicAndShow$12.L$4;
                    option = (Option) aIOChainAniStickerApiImpl$preparePicAndShow$12.L$3;
                    CoroutineScope coroutineScope3 = (CoroutineScope) aIOChainAniStickerApiImpl$preparePicAndShow$12.L$2;
                    Activity activity3 = (Activity) aIOChainAniStickerApiImpl$preparePicAndShow$12.L$1;
                    AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl2 = (AIOChainAniStickerApiImpl) aIOChainAniStickerApiImpl$preparePicAndShow$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    i19 = i27;
                    i18 = i28;
                    objectRef = objectRef2;
                    picLocalPath = str2;
                    coroutineScope2 = coroutineScope3;
                    aIOChainAniStickerApiImpl = aIOChainAniStickerApiImpl2;
                    activity2 = activity3;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!booleanRef.element) {
                    if (objectRef.element != 0) {
                        QLog.i(TAG, 1, "file exist, showShareActionSheet, path:" + picLocalPath);
                        T t16 = objectRef.element;
                        Intrinsics.checkNotNull(t16);
                        String str3 = (String) ((Pair) t16).getFirst();
                        T t17 = objectRef.element;
                        Intrinsics.checkNotNull(t17);
                        aIOChainAniStickerApiImpl.showShareActionSheet(activity2, str3, (Bitmap) ((Pair) t17).getSecond(), i18, i19);
                    } else {
                        QLog.i(TAG, 1, "file exist, compositeImage failed, path:" + picLocalPath);
                    }
                    return Unit.INSTANCE;
                }
                final Ref.ObjectRef objectRef3 = objectRef;
                final String str4 = picLocalPath;
                QQPicLoader.f201806a.d().download(option, new IPicLoadStateListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.f
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option2) {
                        AIOChainAniStickerApiImpl.preparePicAndShow$lambda$2(CoroutineScope.this, objectRef3, str4, aIOChainAniStickerApiImpl, activity2, i18, i19, loadState, option2);
                    }
                });
                return Unit.INSTANCE;
            }
        }
        aIOChainAniStickerApiImpl$preparePicAndShow$1 = new AIOChainAniStickerApiImpl$preparePicAndShow$1(this, continuation);
        AIOChainAniStickerApiImpl$preparePicAndShow$1 aIOChainAniStickerApiImpl$preparePicAndShow$122 = aIOChainAniStickerApiImpl$preparePicAndShow$1;
        Object obj2 = aIOChainAniStickerApiImpl$preparePicAndShow$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = aIOChainAniStickerApiImpl$preparePicAndShow$122.label;
        if (i17 != 0) {
        }
        if (!booleanRef.element) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showShareActionSheet(final Activity activity, String path, Bitmap bitmap, final int serverId, final int reportChatType) {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("chain_ani_sticker_only_on_aio_130916059", true);
        QLog.i(TAG, 1, "showShareActionSheet  prepareToShare:" + this.prepareToShare + ", isSwitchOn:" + isSwitchOn);
        if (this.prepareToShare || !isSwitchOn) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = activity;
            param.reportDataR2 = reportChatType;
            param.reportDataR3 = serverId;
            final String stringExtra = activity.getIntent().getStringExtra("big_brother_source_key");
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_chain_emoji_egg_share");
            ShareActionSheetWithPreview shareActionSheetWithPreview = new ShareActionSheetWithPreview(param);
            setActionSheetContent(shareActionSheetWithPreview);
            shareActionSheetWithPreview.D0(bitmap);
            shareActionSheetWithPreview.setRowVisibility(8, 0, 0);
            setShareActionSheetClickListener(activity, shareActionSheetWithPreview, bitmap, path, serverId);
            shareActionSheetWithPreview.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AIOChainAniStickerApiImpl.showShareActionSheet$lambda$11$lambda$8(AIOChainAniStickerApiImpl.this, serverId, reportChatType, dialogInterface);
                }
            });
            shareActionSheetWithPreview.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.c
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    AIOChainAniStickerApiImpl.showShareActionSheet$lambda$11$lambda$9(AIOChainAniStickerApiImpl.this, serverId, reportChatType, dialogInterface);
                }
            });
            shareActionSheetWithPreview.setWatchDismissListener(new ActionSheet.WatchDismissActions() { // from class: com.tencent.qqnt.aio.adapter.api.impl.d
                @Override // com.tencent.widget.ActionSheet.WatchDismissActions
                public final void onDismissOperations() {
                    AIOChainAniStickerApiImpl.showShareActionSheet$lambda$11$lambda$10(activity, stringExtra);
                }
            });
            shareActionSheetWithPreview.show();
            this.shareActionSheetRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(shareActionSheetWithPreview);
        }
    }
}
