package com.tencent.mobileqq.aio.input.at.common;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\u0010\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\tH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/l;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Lcom/tencent/mobileqq/aio/input/at/common/f;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "dismissDialog", "", "isShowing", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", VideoTemplateParser.ITEM_LIST, "Lkotlin/Pair;", "", "", "index", "b", "a", "Lcom/tencent/mobileqq/aio/input/at/common/i;", "Lcom/tencent/mobileqq/aio/input/at/common/i;", "mListDialog", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/i;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l<T extends c> implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i<T> mListDialog;

    public l(@NotNull i<T> mListDialog) {
        Intrinsics.checkNotNullParameter(mListDialog, "mListDialog");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mListDialog);
        } else {
            this.mListDialog = mListDialog;
        }
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.f
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mListDialog.c().g();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.f
    public void b(@NotNull List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList, @NotNull List<Pair<String, Integer>> index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) itemList, (Object) index);
            return;
        }
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(index, "index");
        this.mListDialog.n(itemList, index);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.f
    public void dismissDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mListDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.f
    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mListDialog.isShowing();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mListDialog.onDestroy();
        }
    }
}
