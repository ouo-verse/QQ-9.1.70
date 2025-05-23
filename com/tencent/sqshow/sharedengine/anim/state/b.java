package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J.\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/sharedengine/anim/state/b;", "", "", "getStateType", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/sqshow/sharedengine/anim/state/a;", "listener", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface b {
    void a(c zplanSpanContext, EnumUserGender gender, FilamentUrlTemplate urlTemplate, com.tencent.sqshow.sharedengine.anim.state.a listener);

    int getStateType();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, c cVar, EnumUserGender enumUserGender, FilamentUrlTemplate filamentUrlTemplate, com.tencent.sqshow.sharedengine.anim.state.a aVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    aVar = null;
                }
                bVar.a(cVar, enumUserGender, filamentUrlTemplate, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchAnim");
        }
    }
}
