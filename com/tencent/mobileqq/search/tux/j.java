package com.tencent.mobileqq.search.tux;

import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/tux/j;", "Lcom/tencent/mobileqq/search/tux/b;", "", "showed", "", "e", "c", AudioContext.State.CLOSED, "f", "a", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "b", "d", "removeTuxItem", "Lcom/tencent/mobileqq/search/tux/a;", "remover", "g", "Lcom/tencent/mobileqq/search/tux/a;", "searchTuxRemover", "Z", "hasSearchTuxShowed", "hasSearchTuxClosed", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "cacheSurveyConfig", "<init>", "(Lcom/tencent/mobileqq/search/tux/a;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class j implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a searchTuxRemover;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasSearchTuxShowed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasSearchTuxClosed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TuxSurveyConfig cacheSurveyConfig;

    public j(@Nullable a aVar) {
        this.searchTuxRemover = aVar;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    /* renamed from: a, reason: from getter */
    public boolean getHasSearchTuxClosed() {
        return this.hasSearchTuxClosed;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    public void b(@Nullable TuxSurveyConfig surveyConfig) {
        this.cacheSurveyConfig = surveyConfig;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    /* renamed from: c, reason: from getter */
    public boolean getHasSearchTuxShowed() {
        return this.hasSearchTuxShowed;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    @Nullable
    /* renamed from: d, reason: from getter */
    public TuxSurveyConfig getCacheSurveyConfig() {
        return this.cacheSurveyConfig;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    public void e(boolean showed) {
        this.hasSearchTuxShowed = showed;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    public void f(boolean closed) {
        this.hasSearchTuxClosed = closed;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    public void g(@Nullable a remover) {
        this.searchTuxRemover = remover;
    }

    @Override // com.tencent.mobileqq.search.tux.b
    public void removeTuxItem() {
        a aVar = this.searchTuxRemover;
        if (aVar != null) {
            aVar.removeTuxItem();
        }
    }

    public /* synthetic */ j(a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar);
    }
}
