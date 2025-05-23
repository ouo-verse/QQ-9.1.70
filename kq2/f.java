package kq2;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.setting.mode.ModeChoiceFragment;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\bH\u0016J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0012"}, d2 = {"Lkq2/f;", "Ljq2/c;", "j", "i", tl.h.F, "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "title", "Landroid/content/Context;", "context", "id", "", "f", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends jq2.c {
    private final jq2.c h() {
        if (DarkModeManager.m()) {
            return null;
        }
        return new rq2.c();
    }

    private final jq2.c i() {
        if (DarkModeManager.m()) {
            return null;
        }
        return new rq2.d();
    }

    private final jq2.c j() {
        if (com.tencent.mobileqq.studymode.g.a() == 1) {
            return new rq2.f();
        }
        return null;
    }

    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayList = new ArrayList<>();
        arrayList.add(new rq2.a());
        arrayList.add(new rq2.g());
        arrayList.add(new rq2.h());
        arrayList.add(new rq2.b());
        jq2.c j3 = j();
        if (j3 != null) {
            arrayList.add(j3);
        }
        arrayList.add(new rq2.e());
        jq2.c i3 = i();
        if (i3 != null) {
            arrayList.add(i3);
        }
        jq2.c h16 = h();
        if (h16 != null) {
            arrayList.add(h16);
        }
        return arrayList;
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        String string = BaseApplication.context.getString(R.string.wjw);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026eneral_mode_select_title)");
        return string;
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("setting_search_title", title);
        QPublicFragmentActivity.start(context, intent, ModeChoiceFragment.class);
    }
}
