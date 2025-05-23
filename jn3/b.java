package jn3;

import com.tencent.qqlive.common.api.AegisLogger;
import e55.c;
import hn3.LinkScreenAnchorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ljn3/b;", "Ljn3/a;", "", "b", "Lhn3/a;", "linkScreenAnchorInfo", "", "a", "c", "Le55/a;", "Le55/a;", "currentLinkScreenAnchor", "Z", "isInLinkScreen", "<init>", "()V", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e55.a currentLinkScreenAnchor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isInLinkScreen;

    @Override // jn3.a
    public void a(@NotNull LinkScreenAnchorInfo linkScreenAnchorInfo) {
        Intrinsics.checkNotNullParameter(linkScreenAnchorInfo, "linkScreenAnchorInfo");
        c cVar = new c();
        cVar.f395737c = linkScreenAnchorInfo.getNick();
        cVar.f395738d = linkScreenAnchorInfo.getAvatar();
        cVar.f395736b = linkScreenAnchorInfo.getUin();
        e55.a aVar = new e55.a();
        aVar.f395729a = cVar;
        this.currentLinkScreenAnchor = aVar;
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenStateMgr", "startLinkScreen, currentAnchor: " + this.currentLinkScreenAnchor);
        this.isInLinkScreen = true;
    }

    @Override // jn3.a
    /* renamed from: b, reason: from getter */
    public boolean getIsInLinkScreen() {
        return this.isInLinkScreen;
    }

    @Override // jn3.a
    public void c() {
        AegisLogger.INSTANCE.i("PK_Biz|LinkScreenStateMgr", "endLinkScreen");
        this.currentLinkScreenAnchor = null;
        this.isInLinkScreen = false;
    }
}
