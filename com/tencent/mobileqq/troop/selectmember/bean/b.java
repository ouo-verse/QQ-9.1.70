package com.tencent.mobileqq.troop.selectmember.bean;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.troop.selectmember.bean.a;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/bean/b;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "a", "list", "", "g", "", "isExpanded", "c", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface b extends com.tencent.mobileqq.troop.selectmember.bean.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static boolean a(@NotNull b bVar, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            return a.C8764a.a(bVar, bean);
        }

        public static boolean b(@NotNull b bVar, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            return a.C8764a.b(bVar, bean);
        }

        public static boolean c(@NotNull b bVar) {
            return !bVar.a().isEmpty();
        }

        public static boolean d(@NotNull b bVar) {
            return false;
        }

        @Nullable
        public static List<c> e(@NotNull b bVar, @Nullable LiveData<List<c>> liveData) {
            List<c> value;
            if (liveData != null && (value = liveData.getValue()) != null) {
                List<c> a16 = bVar.a();
                ArrayList arrayList = new ArrayList();
                for (Object obj : a16) {
                    if (value.contains((c) obj)) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
            return null;
        }

        public static boolean f(@NotNull b bVar) {
            return true;
        }
    }

    @NotNull
    List<c> a();

    boolean c();

    boolean canShow();

    void g(@NotNull List<? extends c> list);

    boolean isExpanded();
}
