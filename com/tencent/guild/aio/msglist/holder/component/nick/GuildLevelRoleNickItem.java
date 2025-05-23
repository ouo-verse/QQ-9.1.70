package com.tencent.guild.aio.msglist.holder.component.nick;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010,\u001a\u00020'\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J&\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J\"\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u000eH\u0003J\u001e\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0014H\u0016R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildLevelRoleNickItem;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "isRefresh", "", "D", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$b;", "u", "", "levelIconUrl", "Lkotlin/Function1;", "block", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "bitmapOrg", "", "max", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "aliveCount", "iconUrl", ReportConstant.COSTREPORT_PREFIX, "B", "w", "icon", "Landroid/graphics/drawable/Drawable;", "image", "text", BdhLogUtil.LogTag.Tag_Conn, "", "", "payloads", "a", "type", "f", "Landroid/content/Context;", "c", "Landroid/content/Context;", "v", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView;", "d", "Lkotlin/Lazy;", "y", "()Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView;", "mLevelRoleGroup", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "curMsgItem", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLevelRoleNickItem extends r {

    /* renamed from: g, reason: collision with root package name */
    private static final int f111575g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f111576h;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mLevelRoleGroup;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem curMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/nick/GuildLevelRoleNickItem$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Bitmap, Unit> f111580e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ GuildLevelRoleNickItem f111581f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Bitmap, Unit> function1, GuildLevelRoleNickItem guildLevelRoleNickItem) {
            super(true);
            this.f111580e = function1;
            this.f111581f = guildLevelRoleNickItem;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(GuildLevelRoleNickItem this$0, Bitmap bitmap, final Function1 block, final Option option) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(block, "$block");
            Intrinsics.checkNotNullParameter(option, "$option");
            final Bitmap A = this$0.A(bitmap, GuildLevelRoleNickItem.f111576h);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLevelRoleNickItem.b.g(Function1.this, A, option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Function1 block, Bitmap bitmap, Option option) {
            Intrinsics.checkNotNullParameter(block, "$block");
            Intrinsics.checkNotNullParameter(option, "$option");
            try {
                block.invoke(bitmap);
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "loadCommonPic invoke cb exception. seq: " + option.getSeq() + ", " + e16.getMessage();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildLevelRoleNickItem", 1, (String) it.next(), null);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull final Option option) {
            Unit unit;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            final Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null) {
                final Function1<Bitmap, Unit> function1 = this.f111580e;
                final GuildLevelRoleNickItem guildLevelRoleNickItem = this.f111581f;
                if (resultBitMap.isRecycled()) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "loadCommonPic onStateChangeCallback resultBitmap: " + resultBitMap + " isRecycled: " + resultBitMap.isRecycled() + " seq: " + option.getSeq();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GuildLevelRoleNickItem", 1, (String) it.next(), null);
                    }
                    function1.invoke(null);
                } else if (resultBitMap.getWidth() == GuildLevelRoleNickItem.f111576h && resultBitMap.getHeight() == GuildLevelRoleNickItem.f111576h) {
                    function1.invoke(resultBitMap);
                } else {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildLevelRoleNickItem.b.f(GuildLevelRoleNickItem.this, resultBitMap, function1, option);
                        }
                    }, 16, null, true);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.f111580e.invoke(null);
            }
        }
    }

    static {
        GuildLevelRoleView.Companion companion = GuildLevelRoleView.INSTANCE;
        f111575g = (int) companion.g();
        f111576h = (int) companion.f();
    }

    public GuildLevelRoleNickItem(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildLevelRoleView>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem$mLevelRoleGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLevelRoleView invoke() {
                int i3;
                GuildLevelRoleView guildLevelRoleView = new GuildLevelRoleView(GuildLevelRoleNickItem.this.getContext(), null, 0, 6, null);
                GuildLevelRoleNickItem guildLevelRoleNickItem = GuildLevelRoleNickItem.this;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = ViewUtils.dpToPx(6.0f);
                i3 = GuildLevelRoleNickItem.f111575g;
                layoutParams.height = i3;
                layoutParams.gravity = 16;
                guildLevelRoleView.setLayoutParams(layoutParams);
                guildLevelRoleView.setVisibility(8);
                guildLevelRoleNickItem.b(guildLevelRoleView);
                return guildLevelRoleView;
            }
        });
        this.mLevelRoleGroup = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap A(Bitmap bitmapOrg, int max) {
        int coerceAtLeast;
        boolean z16;
        Bitmap bitmap = null;
        if (bitmapOrg == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(width, height);
        float f16 = max / (coerceAtLeast * 1.0f);
        if (f16 == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && f16 > 0.0f) {
            try {
                matrix.postScale(f16, f16);
                bitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, height, matrix, true);
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "scaleBitmap : " + e16.getMessage();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildLevelRoleNickItem", 1, (String) it.next(), null);
                }
            } catch (OutOfMemoryError unused) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("scaleBitmap :  scaleBitmap OOM");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("GuildLevelRoleNickItem", 1, (String) it5.next(), null);
                }
            }
        }
        if (bitmap != null) {
            return bitmap;
        }
        return bitmapOrg;
    }

    private final void B(final String aliveCount, final String iconUrl) {
        GuildLevelRoleViewForProfileCard.INSTANCE.b(iconUrl, new Function1<Bitmap, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem$showGuildLevelRoleToast$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                String string = GuildLevelRoleNickItem.this.getContext().getResources().getString(R.string.f147340wm, aliveCount);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_role_active, aliveCount)");
                if (bitmap != null && !bitmap.isRecycled()) {
                    GuildLevelRoleNickItem.this.C(0, new BitmapDrawable(bitmap), string);
                    return;
                }
                QLog.w("GuildLevelRoleNickItem", 1, "showGuildAliveToast bitmap: " + bitmap + ",iconUrl: " + iconUrl);
                QQToast.makeText(GuildLevelRoleNickItem.this.getContext(), 0, string, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"WrongConstant"})
    public final void C(int icon, Drawable image, String text) {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        QQToast qQToast = new QQToast(context);
        qQToast.setToastIcon(image);
        qQToast.setType(icon);
        qQToast.setToastMsg(text);
        qQToast.setDuration(0);
        qQToast.setThemeId(1000);
        qQToast.show();
    }

    private final void D(final GuildMsgItem msgItem, final boolean isRefresh) {
        com.tencent.guild.aio.util.h hVar = com.tencent.guild.aio.util.h.f112401a;
        if (hVar.x(msgItem)) {
            y().setVisibility(8);
            return;
        }
        GuildLevelRoleView.UIData e16 = hVar.e(msgItem);
        if (!isRefresh && e16 != null) {
            y().s(e16);
            s(msgItem, e16.getLevelDesc(), e16.getLevelIconUrl());
        } else {
            w(msgItem, new Function1<IGProGuildRoleInfo, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem$updateIdentityItem$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProGuildRoleInfo iGProGuildRoleInfo) {
                    invoke2(iGProGuildRoleInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable final IGProGuildRoleInfo iGProGuildRoleInfo) {
                    GuildLevelRoleView y16;
                    y16 = GuildLevelRoleNickItem.this.y();
                    if (y16.getVisibility() == 0) {
                        final GuildLevelRoleNickItem guildLevelRoleNickItem = GuildLevelRoleNickItem.this;
                        guildLevelRoleNickItem.h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem$updateIdentityItem$1.1
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
                                GuildLevelRoleView y17;
                                y17 = GuildLevelRoleNickItem.this.y();
                                y17.setVisibility(8);
                            }
                        });
                    }
                    if (QLog.isDebugVersion()) {
                        Logger logger = Logger.f235387a;
                        GuildMsgItem guildMsgItem = msgItem;
                        boolean z16 = isRefresh;
                        logger.d().i("GuildLevelRoleNickItem", 1, "getGuildRoleInfo: msgSeq\uff1a " + guildMsgItem.getMsgSeq() + ", channelId: " + guildMsgItem.getMsgRecord().peerUid + ", senderUid: " + guildMsgItem.getMsgRecord().senderUid + ", isRefresh: " + z16 + " guildRoleInfo: " + iGProGuildRoleInfo);
                    }
                    if (iGProGuildRoleInfo != null) {
                        String levelIconUrl = iGProGuildRoleInfo.getLevelIconUrl();
                        Intrinsics.checkNotNullExpressionValue(levelIconUrl, "guildRoleInfo.levelIconUrl");
                        if (!(levelIconUrl.length() == 0)) {
                            String levelDesc = iGProGuildRoleInfo.getLevelDesc();
                            Intrinsics.checkNotNullExpressionValue(levelDesc, "guildRoleInfo.levelDesc");
                            if (!(levelDesc.length() == 0)) {
                                GuildLevelRoleNickItem guildLevelRoleNickItem2 = GuildLevelRoleNickItem.this;
                                String levelIconUrl2 = iGProGuildRoleInfo.getLevelIconUrl();
                                Intrinsics.checkNotNullExpressionValue(levelIconUrl2, "guildRoleInfo.levelIconUrl");
                                final GuildLevelRoleNickItem guildLevelRoleNickItem3 = GuildLevelRoleNickItem.this;
                                final GuildMsgItem guildMsgItem2 = msgItem;
                                guildLevelRoleNickItem2.z(levelIconUrl2, new Function1<Bitmap, Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem$updateIdentityItem$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                                        invoke2(bitmap);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@Nullable Bitmap bitmap) {
                                        GuildLevelRoleView.UIData u16;
                                        GuildLevelRoleView y17;
                                        if (bitmap == null) {
                                            return;
                                        }
                                        u16 = GuildLevelRoleNickItem.this.u(bitmap, iGProGuildRoleInfo);
                                        y17 = GuildLevelRoleNickItem.this.y();
                                        y17.s(u16);
                                        com.tencent.guild.aio.util.h.f112401a.E(u16, guildMsgItem2);
                                        GuildLevelRoleNickItem guildLevelRoleNickItem4 = GuildLevelRoleNickItem.this;
                                        GuildMsgItem guildMsgItem3 = guildMsgItem2;
                                        String levelDesc2 = iGProGuildRoleInfo.getLevelDesc();
                                        Intrinsics.checkNotNullExpressionValue(levelDesc2, "guildRoleInfo.levelDesc");
                                        String levelIconUrl3 = iGProGuildRoleInfo.getLevelIconUrl();
                                        Intrinsics.checkNotNullExpressionValue(levelIconUrl3, "guildRoleInfo.levelIconUrl");
                                        guildLevelRoleNickItem4.s(guildMsgItem3, levelDesc2, levelIconUrl3);
                                    }
                                });
                                return;
                            }
                        }
                    }
                    final GuildLevelRoleNickItem guildLevelRoleNickItem4 = GuildLevelRoleNickItem.this;
                    guildLevelRoleNickItem4.h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem$updateIdentityItem$1.3
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
                            GuildLevelRoleView y17;
                            GuildLevelRoleView y18;
                            y17 = GuildLevelRoleNickItem.this.y();
                            y17.setVisibility(8);
                            y18 = GuildLevelRoleNickItem.this.y();
                            y18.setOnClickListener(null);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(final GuildMsgItem msgItem, final String aliveCount, final String iconUrl) {
        y().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLevelRoleNickItem.t(GuildLevelRoleNickItem.this, msgItem, aliveCount, iconUrl, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildLevelRoleNickItem this$0, GuildMsgItem msgItem, String aliveCount, String iconUrl, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(aliveCount, "$aliveCount");
        Intrinsics.checkNotNullParameter(iconUrl, "$iconUrl");
        if (this$0.context instanceof Activity) {
            String a16 = com.tencent.guild.aio.util.ex.f.a(msgItem);
            if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isGuest(a16)) {
                this$0.B(aliveCount, iconUrl);
            } else {
                String str = "https://qun.qq.com/guild/h5/guild-level/index.html?guild_id=" + a16 + "&from=4&user_type=" + v.c(a16);
                String str2 = msgItem.getMsgRecord().senderUid;
                QRouteApi api = QRoute.api(IGuildWebApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IGuildWebApi::class.java)");
                IGuildWebApi.a.a((IGuildWebApi) api, this$0.context, str, null, str2, a16, 4, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildLevelRoleView.UIData u(Bitmap bitmap, IGProGuildRoleInfo roleInfo) {
        String levelIconUrl = roleInfo.getLevelIconUrl();
        Intrinsics.checkNotNullExpressionValue(levelIconUrl, "roleInfo.levelIconUrl");
        String levelSimpleDsc = roleInfo.getLevelSimpleDsc();
        Intrinsics.checkNotNullExpressionValue(levelSimpleDsc, "roleInfo.levelSimpleDsc");
        String name = roleInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "roleInfo.name");
        return new GuildLevelRoleView.UIData(bitmap, levelIconUrl, levelSimpleDsc, name, roleInfo.getBackgroudColor1(), roleInfo.getBackgroudColor2(), roleInfo.getLevelSimpleDscColor(), roleInfo.getLevelSplitLineColor(), roleInfo.getOutlineColor());
    }

    private final void w(GuildMsgItem msgItem, final Function1<? super IGProGuildRoleInfo, Unit> block) {
        FromRoleInfo fromRoleInfo = msgItem.getMsgRecord().levelRoleInfo;
        if (QLog.isDebugVersion()) {
            Logger.f235387a.d().i("GuildLevelRoleNickItem", 1, "getGuildRoleInfo: getRoleFromMsg. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", guildId: " + msgItem.getMsgRecord().guildId + ", levelRoleInfo: " + fromRoleInfo);
        }
        ((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getLevelRoleInfo(msgItem.getMsgRecord().guildId, msgItem.getMsgRecord().senderUid, String.valueOf(fromRoleInfo.roleId), new IGuildRoleGroupApi.a() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.f
            @Override // com.tencent.mobileqq.guild.api.IGuildRoleGroupApi.a
            public final void a(IGProGuildRoleInfo iGProGuildRoleInfo) {
                GuildLevelRoleNickItem.x(Function1.this, iGProGuildRoleInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 block, IGProGuildRoleInfo iGProGuildRoleInfo) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke(iGProGuildRoleInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildLevelRoleView y() {
        return (GuildLevelRoleView) this.mLevelRoleGroup.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String levelIconUrl, Function1<? super Bitmap, Unit> block) {
        Option needFilterUrl = new Option().setUrl(levelIconUrl).setPredecode(true).setNeedFilterUrl(false);
        int i3 = f111576h;
        com.tencent.mobileqq.guild.picload.e.a().f(needFilterUrl.setRequestWidth(i3).setRequestHeight(i3), new b(block, this));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
        D(msgItem, false);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.r
    public void f(@NotNull GuildMsgItem msgItem, int type) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (type == 4) {
            h.MemberRoleInfo d16 = d(msgItem);
            boolean z16 = false;
            if (d16 != null && d16.getType() == 6) {
                z16 = true;
            }
            if (z16) {
                h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildLevelRoleNickItem$refresh$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        GuildLevelRoleView y16;
                        y16 = GuildLevelRoleNickItem.this.y();
                        y16.setVisibility(8);
                    }
                });
            } else {
                D(msgItem, true);
            }
        }
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}
