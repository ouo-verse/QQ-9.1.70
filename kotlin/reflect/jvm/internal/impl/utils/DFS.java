package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DFS {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class CollectingNodeHandler<N, R, C extends Iterable<R>> extends AbstractNodeHandler<N, C> {

        @NotNull
        protected final C result;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            if (i3 != 1) {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i3 != 1) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1) {
                objArr[0] = "result";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            }
            if (i3 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            } else {
                objArr[1] = "result";
            }
            if (i3 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i3 != 1) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        protected CollectingNodeHandler(@NotNull C c16) {
            if (c16 == null) {
                $$$reportNull$$$0(0);
            }
            this.result = c16;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        @NotNull
        public C result() {
            C c16 = this.result;
            if (c16 == null) {
                $$$reportNull$$$0(1);
            }
            return c16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface Neighbors<N> {
        @NotNull
        Iterable<? extends N> getNeighbors(N n3);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface NodeHandler<N, R> {
        void afterChildren(N n3);

        boolean beforeChildren(N n3);

        R result();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class NodeHandlerWithListResult<N, R> extends CollectingNodeHandler<N, R, LinkedList<R>> {
        /* JADX INFO: Access modifiers changed from: protected */
        public NodeHandlerWithListResult() {
            super(new LinkedList());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface Visited<N> {
        boolean checkAndMarkVisited(N n3);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class VisitedWithSet<N> implements Visited<N> {
        private final Set<N> visited;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        public VisitedWithSet() {
            this(new HashSet());
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Visited
        public boolean checkAndMarkVisited(N n3) {
            return this.visited.add(n3);
        }

        public VisitedWithSet(@NotNull Set<N> set) {
            if (set == null) {
                $$$reportNull$$$0(0);
            }
            this.visited = set;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        Object[] objArr = new Object[3];
        switch (i3) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case 21:
            case 23:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case 19:
            case 24:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case 25:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case 20:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case 22:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i3) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                objArr[2] = "topologicalOrder";
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <N, R> R dfs(@NotNull Collection<N> collection, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited, @NotNull NodeHandler<N, R> nodeHandler) {
        if (collection == null) {
            $$$reportNull$$$0(0);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(1);
        }
        if (visited == null) {
            $$$reportNull$$$0(2);
        }
        if (nodeHandler == null) {
            $$$reportNull$$$0(3);
        }
        Iterator<N> it = collection.iterator();
        while (it.hasNext()) {
            doDfs(it.next(), neighbors, visited, nodeHandler);
        }
        return nodeHandler.result();
    }

    public static <N> void doDfs(@NotNull N n3, @NotNull Neighbors<N> neighbors, @NotNull Visited<N> visited, @NotNull NodeHandler<N, ?> nodeHandler) {
        if (n3 == null) {
            $$$reportNull$$$0(22);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(23);
        }
        if (visited == null) {
            $$$reportNull$$$0(24);
        }
        if (nodeHandler == null) {
            $$$reportNull$$$0(25);
        }
        if (!visited.checkAndMarkVisited(n3) || !nodeHandler.beforeChildren(n3)) {
            return;
        }
        Iterator<? extends N> it = neighbors.getNeighbors(n3).iterator();
        while (it.hasNext()) {
            doDfs(it.next(), neighbors, visited, nodeHandler);
        }
        nodeHandler.afterChildren(n3);
    }

    public static <N> Boolean ifAny(@NotNull Collection<N> collection, @NotNull Neighbors<N> neighbors, @NotNull final Function1<N, Boolean> function1) {
        if (collection == null) {
            $$$reportNull$$$0(7);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(8);
        }
        if (function1 == null) {
            $$$reportNull$$$0(9);
        }
        final boolean[] zArr = new boolean[1];
        return (Boolean) dfs(collection, neighbors, new AbstractNodeHandler<N, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.utils.DFS.1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(N n3) {
                if (((Boolean) Function1.this.invoke(n3)).booleanValue()) {
                    zArr[0] = true;
                }
                return !zArr[0];
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public Boolean result() {
                return Boolean.valueOf(zArr[0]);
            }
        });
    }

    public static <N, R> R dfs(@NotNull Collection<N> collection, @NotNull Neighbors<N> neighbors, @NotNull NodeHandler<N, R> nodeHandler) {
        if (collection == null) {
            $$$reportNull$$$0(4);
        }
        if (neighbors == null) {
            $$$reportNull$$$0(5);
        }
        if (nodeHandler == null) {
            $$$reportNull$$$0(6);
        }
        return (R) dfs(collection, neighbors, new VisitedWithSet(), nodeHandler);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class AbstractNodeHandler<N, R> implements NodeHandler<N, R> {
        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public boolean beforeChildren(N n3) {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public void afterChildren(N n3) {
        }
    }
}
