package com.tencent.mobileqq.guild.channellist;

import com.heytap.databaseengine.apiv3.data.Element;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/r;", "Lcom/tencent/mobileqq/guild/channellist/c;", "", "f", "", "d", "b", "I", "e", "()I", Element.ELEMENT_NAME_DISTANCE, "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class r extends c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int distance;

    public r(int i3) {
        this.distance = i3;
    }

    @Override // com.tencent.mobileqq.guild.channellist.c
    public long d() {
        return Objects.hash(Integer.valueOf(f()));
    }

    /* renamed from: e, reason: from getter */
    public final int getDistance() {
        return this.distance;
    }

    public int f() {
        return 1;
    }
}
