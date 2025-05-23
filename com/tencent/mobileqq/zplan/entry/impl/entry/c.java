package com.tencent.mobileqq.zplan.entry.impl.entry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc3.AigcPreviewParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/entry/impl/entry/c;", "Lqh3/c;", "", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "Lwc3/a;", "d", "Lwc3/a;", "previewParams", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;Lwc3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends qh3.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Bundle bundle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AigcPreviewParams previewParams;

    public c(Context context, ZootopiaSource source, Bundle bundle, AigcPreviewParams previewParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(previewParams, "previewParams");
        this.context = context;
        this.source = source;
        this.bundle = bundle;
        this.previewParams = previewParams;
    }

    @Override // qh3.b
    public void c() {
        Intent a16 = ZootopiaActivity.INSTANCE.a(this.context, ZootopiaActivity.class, AigcPreviewFragment.class, this.source, this.bundle);
        a16.setFlags(65536);
        if (!(this.context instanceof Activity)) {
            a16.addFlags(268435456);
        }
        a16.putExtra("aigc_preview_params", new Gson().toJson(this.previewParams));
        a16.putExtra("key_need_gesture_back", false);
        this.context.startActivity(a16);
    }
}
