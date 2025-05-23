package com.tencent.mobileqq.pymk.api;

import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PYMKTotalData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/d;", "Lcom/tencent/mobileqq/pymk/api/a;", "", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "recommendData", "", "isEnd", "", "d", "Lcom/tencent/mobileqq/pymk/api/c;", "data", "e", "", "uin", "c", "eTag", "b", "Lcom/tencent/mobileqq/data/PYMKTotalData;", "totalInfo", "a", "<init>", "()V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class d implements a {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.a
    public void a(@NotNull PYMKTotalData totalInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) totalInfo);
        } else {
            Intrinsics.checkNotNullParameter(totalInfo, "totalInfo");
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.a
    public void b(@Nullable String eTag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eTag);
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.a
    public void c(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin);
        } else {
            Intrinsics.checkNotNullParameter(uin, "uin");
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.a
    public void d(@NotNull List<? extends MayKnowRecommend> recommendData, boolean isEnd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, recommendData, Boolean.valueOf(isEnd));
        } else {
            Intrinsics.checkNotNullParameter(recommendData, "recommendData");
        }
    }

    @Override // com.tencent.mobileqq.pymk.api.a
    public void e(@NotNull c data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }
}
