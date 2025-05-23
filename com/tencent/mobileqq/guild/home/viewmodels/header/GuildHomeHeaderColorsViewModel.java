package com.tencent.mobileqq.guild.home.viewmodels.header;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderColorsViewModel;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0002H\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderColorsViewModel;", "Lef1/b;", "", "U1", "com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderColorsViewModel$a", "Q1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderColorsViewModel$a;", "", "guildId", "X1", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "W1", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Le12/a;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "kotlin.jvm.PlatformType", "D", "Le12/a;", "_colorsFromCover", "E", "Lkotlin/Lazy;", "S1", "colorChangeListener", UserInfo.SEX_FEMALE, "_bitmapData", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "colorsFromCover", "R1", "bitmapData", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderColorsViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<GuildHomeCoverColors> _colorsFromCover;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy colorChangeListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final e12.a<Bitmap> _bitmapData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeHeaderColorsViewModel$a", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeHeaderRepository$a;", "", "guildId", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "colorInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildHomeHeaderRepository.a {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository.a
        public void a(@NotNull String guildId, @NotNull GuildHomeCoverColors colorInfo) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
            if (!Intrinsics.areEqual(guildId, GuildHomeHeaderColorsViewModel.this.guildId)) {
                return;
            }
            GuildHomeHeaderColorsViewModel.this._colorsFromCover.setValue(colorInfo);
        }
    }

    public GuildHomeHeaderColorsViewModel(@NotNull String guildId) {
        GuildHomeCoverColors b16;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        if (GuildThemeManager.f235286a.b()) {
            b16 = GuildHomeCoverColors.INSTANCE.c(0, -16777216);
        } else {
            b16 = GuildHomeCoverColors.INSTANCE.b(0, -1);
        }
        this._colorsFromCover = new e12.a<>(b16);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeHeaderColorsViewModel$colorChangeListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeHeaderColorsViewModel.a invoke() {
                GuildHomeHeaderColorsViewModel.a Q1;
                Q1 = GuildHomeHeaderColorsViewModel.this.Q1();
                return Q1;
            }
        });
        this.colorChangeListener = lazy;
        this._bitmapData = new e12.a<>();
        GuildHomeHeaderRepository.f225337d.g(S1());
        U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a Q1() {
        return new a();
    }

    private final a S1() {
        return (a) this.colorChangeListener.getValue();
    }

    private final void U1() {
        GuildHomeCoverColors x16 = GuildHomeHeaderRepository.f225337d.x(this.guildId);
        if (x16 != null) {
            this._colorsFromCover.setValue(x16);
        }
    }

    @NotNull
    public final LiveData<Bitmap> R1() {
        return this._bitmapData;
    }

    @NotNull
    public final LiveData<GuildHomeCoverColors> T1() {
        return this._colorsFromCover;
    }

    public final void W1(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this._bitmapData.setValue(bitmap);
    }

    public final void X1(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        U1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GuildHomeHeaderRepository.f225337d.l(S1());
    }
}
