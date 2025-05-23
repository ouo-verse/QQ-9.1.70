package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListAdapterTest {
    static IPatchRedirector $redirector_;

    public AlbumListAdapterTest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Test
    public void getDefaultAlbums() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Before
    public void setUp() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @After
    public void tearDown() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
