package com.tencent.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes27.dex */
public class ExpandableListPosition {
    static IPatchRedirector $redirector_ = null;
    public static final int CHILD = 1;

    /* renamed from: GROUP, reason: collision with root package name */
    public static final int f384545GROUP = 2;
    private static final int MAX_POOL_SIZE = 5;
    private static ArrayList<ExpandableListPosition> sPool;
    public int childPos;
    int flatListPos;
    public int groupPos;
    public int type;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            sPool = new ArrayList<>(5);
        }
    }

    ExpandableListPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static ExpandableListPosition getRecycledOrCreate() {
        synchronized (sPool) {
            if (sPool.size() > 0) {
                ExpandableListPosition remove = sPool.remove(0);
                remove.resetState();
                return remove;
            }
            return new ExpandableListPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExpandableListPosition obtain(int i3, int i16, int i17, int i18) {
        ExpandableListPosition recycledOrCreate = getRecycledOrCreate();
        recycledOrCreate.type = i3;
        recycledOrCreate.groupPos = i16;
        recycledOrCreate.childPos = i17;
        recycledOrCreate.flatListPos = i18;
        return recycledOrCreate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExpandableListPosition obtainChildPosition(int i3, int i16) {
        return obtain(1, i3, i16, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExpandableListPosition obtainGroupPosition(int i3) {
        return obtain(2, i3, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExpandableListPosition obtainPosition(long j3) {
        if (j3 == 4294967295L) {
            return null;
        }
        ExpandableListPosition recycledOrCreate = getRecycledOrCreate();
        recycledOrCreate.groupPos = ExpandableListView.getPackedPositionGroup(j3);
        if (ExpandableListView.getPackedPositionType(j3) == 1) {
            recycledOrCreate.type = 1;
            recycledOrCreate.childPos = ExpandableListView.getPackedPositionChild(j3);
        } else {
            recycledOrCreate.type = 2;
        }
        return recycledOrCreate;
    }

    private void resetState() {
        this.groupPos = 0;
        this.childPos = 0;
        this.flatListPos = 0;
        this.type = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getPackedPosition() {
        if (this.type == 1) {
            return ExpandableListView.getPackedPositionForChild(this.groupPos, this.childPos);
        }
        return ExpandableListView.getPackedPositionForGroup(this.groupPos);
    }

    public void recycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (sPool) {
            if (sPool.size() < 5) {
                sPool.add(this);
            }
        }
    }
}
