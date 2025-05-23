package com.tencent.mobileqq.matchfriend.reborn.couple;

import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0005\u001a\u00020\u0004H&J9\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042'\u0010\u0012\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u000eH&J=\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0000\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\u000eH&J\u0016\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/b;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "T", "", "", "coupleId", QCircleLpReportDc010001.KEY_SUBTYPE, "Lcom/tencent/mobileqq/matchfriend/reborn/couple/a;", "listener", "", "a", "c", "", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "coupleList", "callback", "f", "couple", "b", "newCoupleList", "d", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b<T extends IQQCoupleModel> {
    void a(@NotNull String coupleId, @NotNull String subType, @NotNull a<? super T> listener);

    void b(@NotNull String coupleId, @NotNull String subType, @NotNull Function1<? super T, Unit> callback);

    void c(@NotNull String coupleId, @NotNull String subType, @NotNull a<? super T> listener);

    void d(@NotNull List<? extends T> newCoupleList);

    @NotNull
    List<T> e(@NotNull String coupleId);

    void f(@NotNull String coupleId, @NotNull Function1<? super List<? extends T>, Unit> callback);
}
