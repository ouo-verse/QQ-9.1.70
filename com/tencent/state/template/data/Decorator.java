package com.tencent.state.template.data;

import com.tencent.state.data.Image;
import com.tencent.state.data.Text;
import com.tencent.state.map.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/template/data/Decorator;", "", "image", "Lcom/tencent/state/data/Image;", "location", "Lcom/tencent/state/map/Location;", "text", "Lcom/tencent/state/data/Text;", "(Lcom/tencent/state/data/Image;Lcom/tencent/state/map/Location;Lcom/tencent/state/data/Text;)V", "getImage", "()Lcom/tencent/state/data/Image;", "getLocation", "()Lcom/tencent/state/map/Location;", "getText", "()Lcom/tencent/state/data/Text;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class Decorator {
    private final Image image;
    private final Location location;
    private final Text text;

    public Decorator(Image image, Location location, Text text) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(location, "location");
        this.image = image;
        this.location = location;
        this.text = text;
    }

    public final Image getImage() {
        return this.image;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final Text getText() {
        return this.text;
    }

    public /* synthetic */ Decorator(Image image, Location location, Text text, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(image, location, (i3 & 4) != 0 ? null : text);
    }
}
