package com.tencent.qqnt.ntrelation.intimateinfo.manager.cache;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J6\u0010\n\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007R\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/manager/cache/MutualMarkDrawableUtil;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "friendUid", "tag", "Lkotlin/Function0;", "", "cb", "a", "", "b", "J", "getFLAG_MASK_INTIMACY", "()J", "FLAG_MASK_INTIMACY", "", "c", "I", "MARK_VERSION_NEW", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MutualMarkDrawableUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MutualMarkDrawableUtil f360106a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final long FLAG_MASK_INTIMACY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int MARK_VERSION_NEW;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f360106a = new MutualMarkDrawableUtil();
        FLAG_MASK_INTIMACY = 8L;
        MARK_VERSION_NEW = 1;
    }

    MutualMarkDrawableUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull ArrayList<String> friendUid, @NotNull String tag, @NotNull final Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(friendUid, "friendUid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Context context = MobileQQ.sMobileQQ.getBaseContext();
        ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(friendUid, tag);
        if (intimateSimpleInfoWithUid == null) {
            return;
        }
        QLog.e("MutualMarkDrawableUtil", 1, intimateSimpleInfoWithUid.toString());
        HashMap<String, ArrayList<NTMutualMarkEntity>> hashMap = new HashMap<>();
        for (com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar : intimateSimpleInfoWithUid) {
            String uid = aVar.getUid();
            ArrayList<NTMutualMarkEntity> l3 = aVar.l();
            if (l3 == null) {
                l3 = new ArrayList<>();
            }
            hashMap.put(uid, l3);
        }
        MutualMarkDownloader mutualMarkDownloader = MutualMarkDownloader.f360096a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        mutualMarkDownloader.b(context, hashMap, new Function0<Unit>(cb5) { // from class: com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkDrawableUtil$getMutualMarkDrawableBatch$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<Unit> $cb;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$cb = cb5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cb5);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    this.$cb.invoke();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }
}
