package okhttp3;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;
import okhttp3.Request;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaNetAuthenticator implements Authenticator {
    private InetAddress getConnectToInetAddress(Proxy proxy, HttpUrl httpUrl) throws IOException {
        if (proxy != null && proxy.type() != Proxy.Type.DIRECT) {
            return ((InetSocketAddress) proxy.address()).getAddress();
        }
        return InetAddress.getByName(httpUrl.host());
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) throws IOException {
        boolean z16;
        PasswordAuthentication requestPasswordAuthentication;
        String str;
        List<Challenge> challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        if (response.code() == 407) {
            z16 = true;
        } else {
            z16 = false;
        }
        Proxy proxy = route.proxy();
        int size = challenges.size();
        for (int i3 = 0; i3 < size; i3++) {
            Challenge challenge = challenges.get(i3);
            if ("Basic".equalsIgnoreCase(challenge.scheme())) {
                if (z16) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), getConnectToInetAddress(proxy, url), inetSocketAddress.getPort(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), Authenticator.RequestorType.PROXY);
                } else {
                    requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(url.host(), getConnectToInetAddress(proxy, url), url.port(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), Authenticator.RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    String basic = Credentials.basic(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()), challenge.charset());
                    Request.Builder newBuilder = request.newBuilder();
                    if (z16) {
                        str = "Proxy-Authorization";
                    } else {
                        str = "Authorization";
                    }
                    return newBuilder.header(str, basic).build();
                }
            }
        }
        return null;
    }
}
