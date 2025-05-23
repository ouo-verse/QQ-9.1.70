package an4;

import an4.l;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.manager.IExpandConversationManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0002J \u0010\u0016\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u0019"}, d2 = {"Lan4/l;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/widget/ImageView;", "iconView", "", "url", "", "k", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "l", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Bitmap;", DomainData.DOMAIN_NAME, "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomSpeakingPosInfo;", "posInfo", "", "roomId", "", VirtualAppProxy.KEY_GAME_ID, "g", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f26382a = new l();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"an4/l$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "c", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f26383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f26384b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageView f26385c;

        a(TextView textView, QBaseActivity qBaseActivity, ImageView imageView) {
            this.f26383a = textView;
            this.f26384b = qBaseActivity;
            this.f26385c = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TextView textView, IUserInfo this_run, CommonOuterClass$QQUserId userId) {
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            Intrinsics.checkNotNullParameter(userId, "$userId");
            textView.setText(this_run.i(userId));
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable final IUserInfo result) {
            if (result != null) {
                final TextView textView = this.f26383a;
                QBaseActivity qBaseActivity = this.f26384b;
                ImageView iconView = this.f26385c;
                final CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
                PBUInt64Field pBUInt64Field = commonOuterClass$QQUserId.uid;
                Long c16 = result.c();
                Intrinsics.checkNotNullExpressionValue(c16, "uid()");
                pBUInt64Field.set(c16.longValue());
                commonOuterClass$QQUserId.user_from.set(1);
                textView.post(new Runnable() { // from class: an4.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.a.d(textView, result, commonOuterClass$QQUserId);
                    }
                });
                l lVar = l.f26382a;
                Intrinsics.checkNotNullExpressionValue(iconView, "iconView");
                String f16 = result.f(commonOuterClass$QQUserId);
                Intrinsics.checkNotNullExpressionValue(f16, "avatar(userId)");
                lVar.k(qBaseActivity, iconView, f16);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.f26383a.setText("--");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"an4/l$b", "Lcom/tencent/mobileqq/qqexpand/manager/IExpandConversationManager$a;", "", "hasFinish", "", "cursor", "", "Lug2/a;", "conversations", "", "a", "", "errorCode", "errorMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IExpandConversationManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f26386a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShareActionSheetV2 f26387b;

        b(Bundle bundle, ShareActionSheetV2 shareActionSheetV2) {
            this.f26386a = bundle;
            this.f26387b = shareActionSheetV2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ShareActionSheetV2 sasBuilder, Bundle bundle) {
            Intrinsics.checkNotNullParameter(sasBuilder, "$sasBuilder");
            Intrinsics.checkNotNullParameter(bundle, "$bundle");
            sasBuilder.setExtras(bundle);
            sasBuilder.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ShareActionSheetV2 sasBuilder, Bundle bundle) {
            Intrinsics.checkNotNullParameter(sasBuilder, "$sasBuilder");
            Intrinsics.checkNotNullParameter(bundle, "$bundle");
            sasBuilder.setExtras(bundle);
            sasBuilder.show();
        }

        @Override // com.tencent.mobileqq.qqexpand.manager.IExpandConversationManager.a
        public void a(boolean hasFinish, @Nullable String cursor, @Nullable List<? extends ug2.a> conversations) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Intrinsics.checkNotNull(conversations);
            for (ug2.a aVar : conversations) {
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uin = String.valueOf(aVar.b());
                resultRecord.name = aVar.c();
                resultRecord.uinType = aVar.a();
                arrayList.add(resultRecord);
            }
            this.f26386a.putParcelableArrayList("key_share_expand_friends", arrayList);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ShareActionSheetV2 shareActionSheetV2 = this.f26387b;
            final Bundle bundle = this.f26386a;
            uIHandlerV2.post(new Runnable() { // from class: an4.m
                @Override // java.lang.Runnable
                public final void run() {
                    l.b.e(ShareActionSheetV2.this, bundle);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqexpand.manager.IExpandConversationManager.a
        public void onFail(int errorCode, @Nullable String errorMsg) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ShareActionSheetV2 shareActionSheetV2 = this.f26387b;
            final Bundle bundle = this.f26386a;
            uIHandlerV2.post(new Runnable() { // from class: an4.n
                @Override // java.lang.Runnable
                public final void run() {
                    l.b.d(ShareActionSheetV2.this, bundle);
                }
            });
        }
    }

    l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final QBaseActivity activity, final YoloRoomOuterClass$YoloRoomInfo yoloRoomInfo, final int i3, final ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(yoloRoomInfo, "$yoloRoomInfo");
        if (o.c("share_item_action_" + actionSheetItem.action)) {
            com.tencent.timi.game.utils.l.b("TeamShareUtils", "double click " + actionSheetItem.action);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: an4.i
            @Override // java.lang.Runnable
            public final void run() {
                l.i(ShareActionSheetBuilder.ActionSheetItem.this, activity, yoloRoomInfo, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, QBaseActivity activity, YoloRoomOuterClass$YoloRoomInfo yoloRoomInfo, int i3) {
        Long longOrNull;
        long j3;
        List<Long> listOf;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(yoloRoomInfo, "$yoloRoomInfo");
        int i16 = actionSheetItem.action;
        if (i16 != 2) {
            if (i16 != 178) {
                ((sm4.a) mm4.b.b(sm4.a.class)).m1(null);
                return;
            }
            sm4.a aVar = (sm4.a) mm4.b.b(sm4.a.class);
            String str = actionSheetItem.uin;
            Intrinsics.checkNotNullExpressionValue(str, "item.uin");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(j3));
            aVar.Z0(activity, listOf, String.valueOf(yoloRoomInfo.room_id.get()), i3);
            return;
        }
        ((sm4.a) mm4.b.b(sm4.a.class)).k3(activity, String.valueOf(yoloRoomInfo.room_id.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QBaseActivity activity, View view, ImageView imageView, TextView textView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (actionSheetItem.action != 178) {
            return;
        }
        textView.setText("--");
        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        PBUInt64Field pBUInt64Field = commonOuterClass$QQUserId.uid;
        String str = actionSheetItem.uin;
        Intrinsics.checkNotNullExpressionValue(str, "sheetItem.uin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        pBUInt64Field.set(j3);
        commonOuterClass$QQUserId.user_from.set(1);
        dVar.I3(commonOuterClass$QQUserId, new a(textView, activity, imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Activity activity, ImageView iconView, String url) {
        URLDrawable urlDrawable = URLDrawable.getDrawable(url, (URLDrawable.URLDrawableOptions) null);
        if (urlDrawable.getStatus() == 1) {
            Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
            l(activity, iconView, urlDrawable);
        } else {
            urlDrawable.setURLDrawableListener(new c(activity, iconView, urlDrawable));
            urlDrawable.startDownload(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final Activity activity, final ImageView iconView, URLDrawable urlDrawable) {
        final Drawable currDrawable = urlDrawable.getCurrDrawable();
        if (currDrawable != null) {
            iconView.post(new Runnable() { // from class: an4.j
                @Override // java.lang.Runnable
                public final void run() {
                    l.m(iconView, activity, currDrawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ImageView iconView, Activity activity, Drawable this_run) {
        Intrinsics.checkNotNullParameter(iconView, "$iconView");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        iconView.setImageDrawable(new RoundRectDrawable(activity.getResources(), new RoundRectBitmap(f26382a.n(this_run), this_run.getIntrinsicWidth())));
    }

    private final Bitmap n(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "this.bitmap");
            return bitmap;
        }
        if (drawable instanceof RegionDrawable) {
            Bitmap bitmap2 = ((RegionDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap2, "this.bitmap");
            return bitmap2;
        }
        Bitmap bitmap3 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap3);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(bitmap3, "bitmap");
        return bitmap3;
    }

    public final void g(@Nullable YoloRoomOuterClass$YoloRoomSpeakingPosInfo posInfo, long roomId, final int gameId) {
        final QBaseActivity b16 = vf4.a.b();
        if (b16 == null) {
            return;
        }
        if (posInfo != null && posInfo.guild_id.get() != 0) {
            IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
            long j3 = posInfo.guild_id.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j3);
            iGuildMainFrameApi.openTeamSharePage(b16, sb5.toString(), roomId);
            return;
        }
        final YoloRoomOuterClass$YoloRoomInfo roomInfo = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId).getRoomInfo();
        if (roomInfo == null) {
            return;
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = b16;
        ShareActionSheetV2 shareActionSheetV2 = new ShareActionSheetV2(param);
        shareActionSheetV2.setActionSheetTitle(b16.getString(R.string.hja));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        int i3 = roomInfo.room_type.get();
        if (i3 != 1) {
            switch (i3) {
                case 6:
                    arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(174));
                    break;
                case 7:
                    arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(175));
                    break;
                case 8:
                    arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(173));
                    break;
                case 9:
                    arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(176));
                    break;
            }
        } else {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(172));
        }
        shareActionSheetV2.setActionSheetItems(arrayList, new ArrayList());
        shareActionSheetV2.setRowVisibility(0, 0, 8);
        shareActionSheetV2.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: an4.g
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                l.h(QBaseActivity.this, roomInfo, gameId, actionSheetItem, shareActionSheet);
            }
        });
        b16.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqlive");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_share_to_expand", true);
        shareActionSheetV2.setItemRender(new ShareActionSheetV2.m() { // from class: an4.h
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.m
            public final void a(View view, ImageView imageView, TextView textView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
                l.j(QBaseActivity.this, view, imageView, textView, actionSheetItem);
            }
        });
        ((IExpandConversationManager) QRoute.api(IExpandConversationManager.class)).getConversationList(null, 15, new b(bundle, shareActionSheetV2));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"an4/l$c", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f26388d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f26389e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ URLDrawable f26390f;

        c(Activity activity, ImageView imageView, URLDrawable uRLDrawable) {
            this.f26388d = activity;
            this.f26389e = imageView;
            this.f26390f = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable p06) {
            l lVar = l.f26382a;
            Activity activity = this.f26388d;
            ImageView imageView = this.f26389e;
            URLDrawable urlDrawable = this.f26390f;
            Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
            lVar.l(activity, imageView, urlDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
        }
    }
}
