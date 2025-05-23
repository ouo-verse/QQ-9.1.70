package com.tencent.mobileqq.minigame.metafarm.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.gamecenter.appwidget.ExitBroadcastReceiver;
import com.tencent.mobileqq.gamecenter.util.a;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmConstants;
import com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0005\u00a2\u0006\u0002\u0010\u0002JB\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0012H\u0002J*\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010+\u001a\u00020\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010/\u001a\u00020\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u00100\u001a\u00020\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u000102H\u0016J \u00103\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00104\u001a\u0002052\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u00106\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u00107\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0002J\"\u0010:\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u00108\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0002J,\u0010=\u001a\u00020\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010>\u001a\u0004\u0018\u00010\u000b2\u0006\u0010?\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\tH\u0002J(\u0010@\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J \u0010C\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010D\u001a\u00020\u00152\u0006\u0010A\u001a\u00020BH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmAppWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "()V", "avatarImgData", "Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmAppWidgetProvider$LocalImageData;", "cardImgDataList", "Ljava/util/ArrayList;", "coinImgData", "isOnUpdateFirstTime", "", "lastWidgetData", "Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData;", "levelImgData", "createBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "imagePath", "", "imageData", "defaultResId", "", "radiusDp", "width", "height", "getCardIconId", "index", "getCardTsId", "getCardTxtId", "getForceUpdateIntent", "Landroid/app/PendingIntent;", "getPendingIntentByUrl", WadlProxyConsts.KEY_JUMP_URL, "initViews", "", "data", "views", "Landroid/widget/RemoteViews;", QAdLoginDefine$LoginStatus.IS_LOGIN, "isDayAfterTomorrow", "dateTime", "", "isTomorrow", "onDeleted", "appWidgetIds", "", "onDisabled", "onEnabled", MetaFarmAppWidgetProvider.UPDATE_SOURCE_ONRECEIVE, "intent", "Landroid/content/Intent;", MetaFarmAppWidgetProvider.UPDATE_SOURCE_ONUPDATE, "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "sendProviderUpdateBroadcast", "setBitmap", "viewId", MimeHelper.IMAGE_SUBTYPE_BITMAP, IECSearchBar.METHOD_SET_TEXT, "text", "", "updateAppWidget", "widgetData", "from", "updateCard", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData$CropCard;", "updateCurrentHungryText", "cardTxtId", "Companion", "LocalImageData", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MetaFarmAppWidgetProvider extends AppWidgetProvider {

    @NotNull
    public static final String ACTION_META_FARM_UPDATE = "tencent.notify.appwidget.META_FARM_UPDATE";

    @NotNull
    public static final String ACTION_PROVIDER_UPDATE_WIDGET = "action_provider_update_widget";

    @NotNull
    public static final String DEFAULT_JUMP_URL = "mqqapi://miniapp/open?_atype=1&_mappid=1112288843&_miniapptype=1&_mvid=&_vt=3&via=xbnc_widget&_sig=2058704203";

    @NotNull
    public static final String EXTRA_IS_LOGIN = "extra_is_login";

    @NotNull
    public static final String EXTRA_WIDGET_DATA = "extra_widget_data";

    @NotNull
    private static final String TAG = "MetaFarmAppWidgetProvider";

    @NotNull
    private static final String UPDATE_SOURCE_ONRECEIVE = "onReceive";

    @NotNull
    private static final String UPDATE_SOURCE_ONUPDATE = "onUpdate";

    @Nullable
    private MetaFarmWidgetData lastWidgetData;

    @NotNull
    private LocalImageData avatarImgData = new LocalImageData();

    @NotNull
    private LocalImageData levelImgData = new LocalImageData();

    @NotNull
    private LocalImageData coinImgData = new LocalImageData();

    @NotNull
    private ArrayList<LocalImageData> cardImgDataList = new ArrayList<>();
    private boolean isOnUpdateFirstTime = true;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmAppWidgetProvider$LocalImageData;", "", "()V", "bitMapRef", "Lmqq/util/WeakReference;", "Landroid/graphics/Bitmap;", "getBitMapRef", "()Lmqq/util/WeakReference;", "setBitMapRef", "(Lmqq/util/WeakReference;)V", "imgPath", "", "getImgPath", "()Ljava/lang/String;", "setImgPath", "(Ljava/lang/String;)V", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class LocalImageData {

        @NotNull
        private WeakReference<Bitmap> bitMapRef = new WeakReference<>(null);

        @Nullable
        private String imgPath;

        @NotNull
        public final WeakReference<Bitmap> getBitMapRef() {
            return this.bitMapRef;
        }

        @Nullable
        public final String getImgPath() {
            return this.imgPath;
        }

        public final void setBitMapRef(@NotNull WeakReference<Bitmap> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.bitMapRef = weakReference;
        }

        public final void setImgPath(@Nullable String str) {
            this.imgPath = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap createBitmap(Context context, String imagePath, LocalImageData imageData, int defaultResId, int radiusDp, int width, int height) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (!TextUtils.isEmpty(imagePath)) {
            if (Intrinsics.areEqual(imagePath, imageData.getImgPath()) && (bitmap2 = imageData.getBitMapRef().get()) != null && !bitmap2.isRecycled()) {
                QLog.i(TAG, 2, "createWidgetBitmap use cache bitmap");
                return bitmap2;
            }
            try {
            } catch (OutOfMemoryError unused) {
                bitmap = null;
            }
            if (new File(imagePath).exists()) {
                bitmap = BitmapFactory.decodeFile(imagePath);
                if (bitmap != null && radiusDp > 0) {
                    try {
                        bitmap = BaseImageUtil.getRoundedCornerBitmap2(bitmap, a.a(radiusDp, context.getResources()), width, height);
                    } catch (OutOfMemoryError unused2) {
                        QLog.i(TAG, 2, "createWidgetBitmap oom");
                        if (bitmap == null) {
                        }
                    }
                }
                imageData.setBitMapRef(new WeakReference<>(bitmap));
                imageData.setImgPath(imagePath);
                QLog.i(TAG, 2, "createWidgetBitmap create bitmap:" + imagePath);
                if (bitmap == null) {
                    if (defaultResId == -1) {
                        return null;
                    }
                    Drawable drawable = context.getResources().getDrawable(defaultResId);
                    Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                    Bitmap bitmap3 = ((BitmapDrawable) drawable).getBitmap();
                    if (bitmap3 != null && radiusDp > 0) {
                        return BaseImageUtil.getRoundedCornerBitmap3(bitmap3, a.a(radiusDp, context.getResources()), width, height);
                    }
                    return bitmap3;
                }
                return bitmap;
            }
        }
        bitmap = null;
        if (bitmap == null) {
        }
    }

    private final int getCardIconId(int index) {
        if (index != 0) {
            if (index != 1) {
                if (index != 2) {
                    if (index != 3) {
                        if (index != 4) {
                            return -1;
                        }
                        return R.id.ubt;
                    }
                    return R.id.ubs;
                }
                return R.id.ubr;
            }
            return R.id.ubq;
        }
        return R.id.ubp;
    }

    private final int getCardTsId(int index) {
        if (index != 0) {
            if (index != 1) {
                if (index != 2) {
                    if (index != 3) {
                        if (index != 4) {
                            return -1;
                        }
                        return R.id.uby;
                    }
                    return R.id.ubx;
                }
                return R.id.ubw;
            }
            return R.id.ubv;
        }
        return R.id.ubu;
    }

    private final int getCardTxtId(int index) {
        if (index != 0) {
            if (index != 1) {
                if (index != 2) {
                    if (index != 3) {
                        if (index != 4) {
                            return -1;
                        }
                        return R.id.uc7;
                    }
                    return R.id.uc6;
                }
                return R.id.uc5;
            }
            return R.id.f164936uc4;
        }
        return R.id.f164935uc3;
    }

    private final PendingIntent getForceUpdateIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver");
        intent.setAction(MetaFarmConstants.UPDATE_WIDGET_RECEIVER_ACTION);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(context, 0,\u2026ingIntent.FLAG_IMMUTABLE)");
        return broadcast;
    }

    private final PendingIntent getPendingIntentByUrl(Context context, String jumpUrl) {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(jumpUrl));
        intent.addFlags(268435456);
        return PendingIntent.getActivity(context, 0, intent, 67108864);
    }

    private final void initViews(Context context, MetaFarmWidgetData data, RemoteViews views, boolean isLogin) {
        String str;
        String str2;
        boolean z16;
        String str3;
        boolean z17;
        float f16;
        String str4;
        String str5;
        String str6;
        MetaFarmWidgetData.UserInfo userInfo;
        String str7;
        MetaFarmWidgetData.UserInfo userInfo2;
        Integer num;
        Integer num2;
        MetaFarmWidgetData.UserInfo userInfo3;
        MetaFarmWidgetData.UserInfo userInfo4;
        String str8;
        MetaFarmWidgetData.UserInfo userInfo5;
        MetaFarmWidgetData.UserInfo userInfo6;
        String str9;
        MetaFarmWidgetData.UserInfo userInfo7;
        MetaFarmWidgetData.UserInfo userInfo8;
        String str10;
        MetaFarmWidgetData.UserInfo userInfo9;
        MetaFarmWidgetData.UserInfo userInfo10;
        if (data == null || (str = data.getJumpUrl()) == null) {
            str = DEFAULT_JUMP_URL;
        }
        PendingIntent pendingIntentByUrl = getPendingIntentByUrl(context, str);
        views.setOnClickPendingIntent(R.id.f164903u74, pendingIntentByUrl);
        views.setOnClickPendingIntent(R.id.u7o, pendingIntentByUrl);
        views.setOnClickPendingIntent(R.id.xeh, getForceUpdateIntent(context));
        views.setOnClickPendingIntent(R.id.f113026pi, getForceUpdateIntent(context));
        if (isLogin) {
            views.setViewVisibility(R.id.u7o, 0);
            views.setViewVisibility(R.id.f164903u74, 8);
            if (data != null && (userInfo10 = data.getUserInfo()) != null) {
                str2 = userInfo10.getAvatarImgPath();
            } else {
                str2 = null;
            }
            boolean z18 = true;
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (data != null && (userInfo9 = data.getUserInfo()) != null) {
                    str10 = userInfo9.getAvatarImgPath();
                } else {
                    str10 = null;
                }
                Intrinsics.checkNotNull(str10);
                setBitmap(views, R.id.xjr, createBitmap(context, str10, this.avatarImgData, -1, 15, a.a(30.0f, context.getResources()), a.a(30.0f, context.getResources())));
            }
            if (data != null && (userInfo8 = data.getUserInfo()) != null) {
                str3 = userInfo8.getLevelIconImgPath();
            } else {
                str3 = null;
            }
            if (str3 != null && str3.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (data != null && (userInfo7 = data.getUserInfo()) != null) {
                    str9 = userInfo7.getLevelIconImgPath();
                } else {
                    str9 = null;
                }
                Intrinsics.checkNotNull(str9);
                f16 = 16.0f;
                setBitmap(views, R.id.xdu, createBitmap(context, str9, this.levelImgData, -1, 0, a.a(16.0f, context.getResources()), a.a(15.0f, context.getResources())));
            } else {
                f16 = 16.0f;
            }
            if (data != null && (userInfo6 = data.getUserInfo()) != null) {
                str4 = userInfo6.getCoinIconImgPath();
            } else {
                str4 = null;
            }
            if (str4 != null && str4.length() != 0) {
                z18 = false;
            }
            if (!z18) {
                if (data != null && (userInfo5 = data.getUserInfo()) != null) {
                    str8 = userInfo5.getCoinIconImgPath();
                } else {
                    str8 = null;
                }
                Intrinsics.checkNotNull(str8);
                setBitmap(views, R.id.xdj, createBitmap(context, str8, this.coinImgData, -1, 0, a.a(f16, context.getResources()), a.a(15.0f, context.getResources())));
            }
            if (data == null || (userInfo4 = data.getUserInfo()) == null || (str5 = userInfo4.getNick()) == null) {
                str5 = "";
            }
            setText(views, R.id.kea, str5);
            String str11 = "0";
            if (data == null || (userInfo3 = data.getUserInfo()) == null || (str6 = userInfo3.getCoinDesc()) == null) {
                str6 = "0";
            }
            setText(views, R.id.kde, str6);
            if (data != null) {
                userInfo = data.getUserInfo();
            } else {
                userInfo = null;
            }
            if (userInfo == null) {
                str7 = "0";
            } else {
                MetaFarmWidgetData.UserInfo userInfo11 = data.getUserInfo();
                if (userInfo11 != null) {
                    num2 = Integer.valueOf(userInfo11.getStealableTimes());
                } else {
                    num2 = null;
                }
                str7 = String.valueOf(num2);
            }
            if (data != null) {
                userInfo2 = data.getUserInfo();
            } else {
                userInfo2 = null;
            }
            if (userInfo2 != null) {
                MetaFarmWidgetData.UserInfo userInfo12 = data.getUserInfo();
                if (userInfo12 != null) {
                    num = Integer.valueOf(userInfo12.getBlessingTimes());
                } else {
                    num = null;
                }
                str11 = String.valueOf(num);
            }
            setText(views, R.id.f113006pg, str7);
            setText(views, R.id.f113016ph, str11);
            if (data != null && data.getCards().size() > 0) {
                if (this.cardImgDataList.size() == 0) {
                    int size = data.getCards().size();
                    for (int i3 = 0; i3 < size; i3++) {
                        this.cardImgDataList.add(new LocalImageData());
                    }
                }
                int size2 = data.getCards().size();
                for (int i16 = 0; i16 < size2; i16++) {
                    MetaFarmWidgetData.CropCard cropCard = data.getCards().get(i16);
                    Intrinsics.checkNotNullExpressionValue(cropCard, "data.cards[i]");
                    updateCard(context, views, cropCard, i16);
                }
            }
            setText(views, R.id.f113026pi, "\u66f4\u65b0\u4e8e" + new SimpleDateFormat("MM-dd HH:mm", Locale.SIMPLIFIED_CHINESE).format(new Date()));
            return;
        }
        views.setViewVisibility(R.id.u7o, 8);
        views.setViewVisibility(R.id.f164903u74, 0);
    }

    private final boolean isDayAfterTomorrow(long dateTime) {
        Date date = new Date(NetConnInfoCenter.getServerTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 2);
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd", Locale.SIMPLIFIED_CHINESE);
        return TextUtils.equals(simpleDateFormat.format(time), simpleDateFormat.format(new Date(dateTime * 1000)));
    }

    private final boolean isTomorrow(long dateTime) {
        Date date = new Date(NetConnInfoCenter.getServerTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 1);
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd", Locale.SIMPLIFIED_CHINESE);
        return TextUtils.equals(simpleDateFormat.format(time), simpleDateFormat.format(new Date(dateTime * 1000)));
    }

    private final void sendProviderUpdateBroadcast(Context context) {
        QLog.d(TAG, 1, "sendProviderUpdateBroadcast");
        context.sendBroadcast(new Intent(ACTION_PROVIDER_UPDATE_WIDGET));
    }

    private final void setBitmap(RemoteViews views, int viewId, Bitmap bitmap) {
        if (views != null && bitmap != null) {
            views.setBitmap(viewId, "setImageBitmap", bitmap);
        }
    }

    private final void setText(RemoteViews views, int viewId, CharSequence text) {
        if (views != null) {
            views.setTextViewText(viewId, text);
        }
    }

    private final void updateAppWidget(Context context, MetaFarmWidgetData widgetData, String from, boolean isLogin) {
        QLog.d(TAG, 1, "updateAppWidget from:" + from + ", isLogin:" + isLogin + ",  process:" + MobileQQ.sMobileQQ.getQQProcessName());
        if (context == null) {
            QLog.e(TAG, 1, "updateAppWidget context null");
            return;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (appWidgetManager == null) {
            return;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.fh9);
        initViews(context, widgetData, remoteViews, isLogin);
        appWidgetManager.updateAppWidget(new ComponentName(context, (Class<?>) MetaFarmAppWidgetProvider.class), remoteViews);
        this.lastWidgetData = widgetData;
    }

    private final void updateCard(Context context, RemoteViews views, MetaFarmWidgetData.CropCard card, int index) {
        boolean z16;
        String str;
        int cardIconId = getCardIconId(index);
        int cardTsId = getCardTsId(index);
        int cardTxtId = getCardTxtId(index);
        boolean z17 = true;
        if (card.getIconImgPath().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String iconImgPath = card.getIconImgPath();
            LocalImageData localImageData = this.cardImgDataList.get(index);
            Intrinsics.checkNotNullExpressionValue(localImageData, "cardImgDataList[index]");
            setBitmap(views, cardIconId, createBitmap(context, iconImgPath, localImageData, -1, 0, a.a(28.0f, context.getResources()), a.a(28.0f, context.getResources())));
        }
        if (card.getTimeText().length() <= 0) {
            z17 = false;
        }
        if (z17) {
            views.setViewVisibility(cardTsId, 0);
            if (isTomorrow(card.getTimestamp())) {
                str = "\u660e\u5929";
            } else if (isDayAfterTomorrow(card.getTimestamp())) {
                str = "\u540e\u5929";
            } else {
                str = "";
            }
            setText(views, cardTsId, str + card.getTimeText());
        } else {
            views.setViewVisibility(cardTsId, 8);
        }
        setText(views, cardTxtId, card.getText());
        if (card.getTextHighlight()) {
            views.setTextColor(cardTxtId, Color.parseColor("#F97801"));
        } else {
            views.setTextColor(cardTxtId, Color.parseColor("#666666"));
        }
        updateCurrentHungryText(views, cardTxtId, card);
    }

    private final void updateCurrentHungryText(RemoteViews views, int cardTxtId, MetaFarmWidgetData.CropCard card) {
        if (Intrinsics.areEqual("\u9965\u997f", card.getText())) {
            if (System.currentTimeMillis() > card.getTimestamp() * 1000) {
                QLog.i(TAG, 1, "isCurrentHungry is true");
                views.setTextColor(cardTxtId, Color.parseColor("#F97801"));
            } else {
                views.setTextColor(cardTxtId, Color.parseColor("#666666"));
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(@Nullable Context context, @Nullable int[] appWidgetIds) {
        QLog.i(TAG, 2, "onDeleted appWidgetIds:" + appWidgetIds);
        super.onDeleted(context, appWidgetIds);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(@Nullable Context context) {
        QLog.i(TAG, 2, "onEnabled");
        super.onDisabled(context);
        ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).clearImgCache();
        ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).reportWidgetRemove();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(@Nullable Context context) {
        QLog.i(TAG, 2, "onEnabled");
        super.onEnabled(context);
        ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).reportWidgetAdd();
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        String str2;
        Object obj;
        String str3;
        boolean z16;
        Bundle extras;
        String str4;
        String str5;
        Bundle extras2;
        Object obj2 = null;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (intent != null) {
            str2 = intent.getPackage();
        } else {
            str2 = null;
        }
        if (intent == null || (extras2 = intent.getExtras()) == null || (obj = extras2.get(EXTRA_IS_LOGIN)) == null) {
            obj = Boolean.TRUE;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onReceive action:");
        sb5.append(str);
        sb5.append(", packageName:");
        sb5.append(str2);
        sb5.append(", isLogin:");
        sb5.append(obj);
        sb5.append(", contextPkg:");
        if (context != null) {
            str3 = context.getPackageName();
        } else {
            str3 = null;
        }
        sb5.append(str3);
        boolean z17 = true;
        QLog.d(TAG, 1, sb5.toString());
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (context != null) {
                str4 = context.getPackageName();
            } else {
                str4 = null;
            }
            if (str4 != null && str4.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                if (context != null) {
                    str5 = context.getPackageName();
                } else {
                    str5 = null;
                }
                if (!Intrinsics.areEqual(str2, str5)) {
                    return;
                }
            }
        }
        ExitBroadcastReceiver.a(context);
        if (Intrinsics.areEqual(str, ACTION_META_FARM_UPDATE)) {
            if (intent != null && (extras = intent.getExtras()) != null) {
                obj2 = extras.get(EXTRA_WIDGET_DATA);
            }
            updateAppWidget(context, (MetaFarmWidgetData) obj2, UPDATE_SOURCE_ONRECEIVE, ((Boolean) obj).booleanValue());
            return;
        }
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
        Boolean bool;
        boolean z16;
        MetaFarmWidgetData metaFarmWidgetData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        if (!this.isOnUpdateFirstTime) {
            QLog.d(TAG, 1, "onUpdate isOnUpdateFirstTime false");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            peekAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onUpdate isLogin:");
        if (peekAppRuntime != null) {
            bool = Boolean.valueOf(peekAppRuntime.isLogin());
        } else {
            bool = null;
        }
        sb5.append(bool);
        sb5.append(", provider:");
        sb5.append(this);
        QLog.d(TAG, 1, sb5.toString());
        if (peekAppRuntime != null) {
            z16 = peekAppRuntime.isLogin();
        } else {
            z16 = false;
        }
        if (z16 && (metaFarmWidgetData = this.lastWidgetData) != null) {
            updateAppWidget(context, metaFarmWidgetData, UPDATE_SOURCE_ONUPDATE, true);
        } else {
            sendProviderUpdateBroadcast(context);
        }
        this.isOnUpdateFirstTime = false;
    }
}
