package com.tencent.mobileqq.search.tux;

import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000e\u001a\u00020\u0004H&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/tux/b;", "", "", "showed", "", "e", "c", AudioContext.State.CLOSED, "f", "a", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "b", "d", "removeTuxItem", "Lcom/tencent/mobileqq/search/tux/a;", "remover", "g", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    boolean a();

    void b(@Nullable TuxSurveyConfig surveyConfig);

    boolean c();

    @Nullable
    TuxSurveyConfig d();

    void e(boolean showed);

    void f(boolean closed);

    void g(@Nullable a remover);

    void removeTuxItem();
}
