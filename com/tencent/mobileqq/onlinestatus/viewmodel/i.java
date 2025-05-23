package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.repository.OnlineStatusLikeRepository;
import com.tencent.mobileqq.onlinestatus.utils.z;
import com.tencent.mobileqq.onlinestatus.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0003J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00060\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00060\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR$\u0010%\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/viewmodel/i;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository;", "", "L1", "T1", "", "index", "Lcom/tencent/mobileqq/onlinestatus/model/d;", "P1", "N1", "", "forceUpdate", "isInitUpdate", "X1", "R1", "likeType", "U1", "O1", "", "M1", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "selectIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q1", "likeInfo", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getMAvatarClickedJumpSchema", "()Ljava/lang/String;", "W1", "(Ljava/lang/String;)V", "mAvatarClickedJumpSchema", "repository", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/repository/OnlineStatusLikeRepository;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i extends com.tencent.mobileqq.mvvm.c<OnlineStatusLikeRepository> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String mAvatarClickedJumpSchema;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> selectIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> likeInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull OnlineStatusLikeRepository repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        repository.v(this);
        this.selectIndex = new MutableLiveData<>(0);
        this.likeInfo = new MutableLiveData<>(0);
    }

    public static /* synthetic */ void Z1(i iVar, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            z17 = false;
        }
        iVar.X1(i3, z16, z17);
    }

    public final void L1() {
        ((OnlineStatusLikeRepository) this.mRepository).l();
    }

    @Nullable
    public final String M1() {
        String str;
        long j3;
        String str2 = this.mAvatarClickedJumpSchema;
        if (str2 != null) {
            return str2;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            j3 = 0;
        } else {
            j3 = 1;
        }
        ((OnlineStatusLikeRepository) this.mRepository).m(N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), j3);
        return "";
    }

    @NotNull
    public final com.tencent.mobileqq.onlinestatus.model.d N1() {
        return P1(R1());
    }

    public final void O1() {
        this.likeInfo.setValue(Integer.valueOf(((OnlineStatusLikeRepository) this.mRepository).r(N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())));
        ((OnlineStatusLikeRepository) this.mRepository).q(N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
    }

    @NotNull
    public final com.tencent.mobileqq.onlinestatus.model.d P1(int index) {
        return ((OnlineStatusLikeRepository) this.mRepository).n(index);
    }

    @NotNull
    public final MutableLiveData<Integer> Q1() {
        return this.likeInfo;
    }

    public final int R1() {
        Integer value = this.selectIndex.getValue();
        if (value == null) {
            return -1;
        }
        return value.intValue();
    }

    @NotNull
    public final MutableLiveData<Integer> S1() {
        return this.selectIndex;
    }

    public final void T1() {
        ((OnlineStatusLikeRepository) this.mRepository).s();
    }

    public final void U1(int likeType) {
        int i3;
        Integer value = this.likeInfo.getValue();
        if (value != null && likeType == value.intValue()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            likeType = 0;
        }
        ((OnlineStatusLikeRepository) this.mRepository).t(N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), likeType, i3);
    }

    public final void W1(@Nullable String str) {
        this.mAvatarClickedJumpSchema = str;
    }

    public final void X1(int index, boolean forceUpdate, boolean isInitUpdate) {
        Integer value = this.selectIndex.getValue();
        if ((value == null || index != value.intValue() || forceUpdate) && index >= 0 && index < ((OnlineStatusLikeRepository) this.mRepository).o()) {
            Integer value2 = this.selectIndex.getValue();
            this.selectIndex.setValue(Integer.valueOf(index));
            if ((value2 == null || value2.intValue() != index) && !isInitUpdate) {
                x.f(N1().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
                z.c("0X800C390");
            }
        }
    }
}
