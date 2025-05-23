package com.google.protobuf.nano;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MapFactories {
    private static volatile MapFactory mapFactory = new DefaultMapFactory();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class DefaultMapFactory implements MapFactory {
        DefaultMapFactory() {
        }

        @Override // com.google.protobuf.nano.MapFactories.MapFactory
        public <K, V> Map<K, V> forMap(Map<K, V> map) {
            if (map == null) {
                return new HashMap();
            }
            return map;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface MapFactory {
        <K, V> Map<K, V> forMap(Map<K, V> map);
    }

    MapFactories() {
    }

    public static MapFactory getMapFactory() {
        return mapFactory;
    }

    static void setMapFactory(MapFactory mapFactory2) {
        mapFactory = mapFactory2;
    }
}
