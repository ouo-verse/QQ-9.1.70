package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigGuideFollowReqUtils;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigRecycleAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J9\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\bR\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/configguidefollow/h;", "", "Le30/b;", "sourceFeed", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/configguidefollow/QFSBottomConfigGuideFollowReqUtils$a;", "callback", "", "c", "", "success", "", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/configguidefollow/d;", "resultList", "", "drawerType", "", "drawerTitle", "f", "(ZLjava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "d", "b", "a", "e", "Z", "isSuccess", "Ljava/util/List;", "I", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isSuccess;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int drawerType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends d> resultList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String drawerTitle = "";

    @NotNull
    public final String a() {
        boolean z16;
        if (this.drawerTitle.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("QFSFeedBottomPYMLFollowAuthorModel", 1, "getDrawerTitle, title is empty return default value.");
            return "\u5173\u6ce8ta\u7684\u4eba\u4e5f\u5173\u6ce8\u4e86";
        }
        return this.drawerTitle;
    }

    /* renamed from: b, reason: from getter */
    public final int getDrawerType() {
        return this.drawerType;
    }

    public final void c(@NotNull e30.b sourceFeed, @NotNull QFSBottomConfigGuideFollowReqUtils.a callback) {
        Intrinsics.checkNotNullParameter(sourceFeed, "sourceFeed");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QFSBottomConfigGuideFollowReqUtils.f(sourceFeed, QFSBottomConfigRecycleAdapter.ShowScene.SCENE_FOLLOW_AUTHOR, callback);
    }

    @NotNull
    public final List<d> d() {
        return this.resultList;
    }

    public final boolean e() {
        if (this.isSuccess && (!this.resultList.isEmpty())) {
            return true;
        }
        return false;
    }

    public final void f(boolean success, @Nullable List<? extends d> resultList, @Nullable Integer drawerType, @Nullable String drawerTitle) {
        this.isSuccess = success;
        if (resultList != null) {
            this.resultList = resultList;
        }
        if (drawerType != null) {
            this.drawerType = drawerType.intValue();
        }
        if (drawerTitle != null) {
            this.drawerTitle = drawerTitle;
        }
    }
}
